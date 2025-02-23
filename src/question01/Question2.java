package question01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {
        List<List<Integer>> list = find(new int[]{10, 9, 8, 3, 1}, 11);
        System.out.println(list);
    }

    public static List<List<Integer>> find(int[] arr, int sum) {
        if (arr.length < 2) {
            return null;
        }

        int left = 0;
        int right = arr.length - 1;

        List<List<Integer>> list = new ArrayList<>();

        while (left <= right) {
            int temp = arr[left] + arr[right];
            if (temp == sum) {
                list.add(Arrays.asList(arr[left] , arr[right]));
                left++;
            }else if (temp > sum) {
                left++;
            }else {
                right--;
            }
        }

        return list;
    }
}
