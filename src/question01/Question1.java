package question01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, -1, 0, 3 , -1};
        List<List<Integer>> list = countList(nums);
        System.out.println(list);
    }

    public static List<List<Integer>> countList(int[] nums) {
        if (nums.length < 3) {
            return null;
        }

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int z = j + 1; z < nums.length; z++) {
                    if (nums[i] + nums[j] + nums[z] == 0) {
                        List<Integer> item = Arrays.asList(nums[i], nums[j], nums[z]);
                        item.sort(Integer::compareTo);
                        set.add(item);
                    }
                }
            }
        }

        return set.stream().toList();
    }
}
