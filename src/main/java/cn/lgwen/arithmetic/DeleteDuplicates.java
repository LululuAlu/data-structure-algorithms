package cn.lgwen.arithmetic;

import java.util.HashSet;
import java.util.Set;

/**
 * 2020/5/23
 * aven.wu
 * danxieai258@163.com
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode a = create(new int[]{1,1,2,3,3});

        new DeleteDuplicates().deleteDuplicates(a);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(0);
        ListNode rs = first;
        Set<Integer> set = new HashSet<>();
        for (ListNode node = head; node != null; node = node.next) {
            if (!set.contains(node.val)) {
                set.add(node.val);
                rs.next = new ListNode(node.val);
                rs = rs.next;
            }
        }
        return first.next;
    }

    public static ListNode create(int[] arrays) {
        ListNode head = new ListNode(arrays[0]);
        ListNode next = head;
        for (int i = 1; i < arrays.length; i++) {
            ListNode tmp = new ListNode(arrays[i]);
            next.next = tmp;
            next = next.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
