package direct01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有两个自定义的无序链表，值是int，现在合并这两个链表，正序排列，并且要去重
 */
public class Question3 {

    public static class Node {
        public Node() {
            this.next = null;
        }

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public int value;

        public Node next;
    }

    public static void main(String[] args) {
        int[] num1 = {8, 0, 4, 5, 0};
        int[] num2 = {3, 0, 1, 5, 5};

        Node root1 = generateNode(num1);
        Node root2 = generateNode(num2);

        Node mergeNode = merge(root1, root2);

        while (mergeNode != null) {
            System.out.print(mergeNode.value + " ");
            mergeNode = mergeNode.next;
        }
    }

    public static Node generateNode(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Node head = new Node(nums[0]);
        Node current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new Node(nums[i]);
            current = current.next;
        }
        return head;
    }

    public static Node merge(Node roo1, Node roo2) {
        if (roo1 == null && roo2 == null) return null;
        if (roo1 == null) return roo2;
        if (roo2 == null) return roo1;

        Map<Integer, Node> map = new HashMap<>();

        Node cur = roo1;
        while (cur != null) {
            if (!map.containsKey(cur.value)) {
                map.put(cur.value, cur);
            }
            cur = cur.next;
        }

        cur = roo2;
        while (cur != null) {
            if (!map.containsKey(cur.value)) {
                map.put(cur.value, cur);
            }
            cur = cur.next;
        }

        List<Integer> list = map.keySet().stream().sorted().toList();
        Node head = new Node();
        Node current = head;
        for (Integer integer : list) {
            current.next = map.get(integer);
            current = current.next;
            current.next = null;
        }

        return head.next;

    }
}
