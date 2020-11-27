package cn.lgwen.arithmetic;

import cn.lgwen.structure.ListNode;

import java.util.Stack;

/**
 * 2020/11/26
 * aven.wu
 * danxieai258@163.com
 * 92. 反转链表 II
 */
public class ReverseBetween {

    public static void main(String[] args) {
        int[] array = new int[]{5};
        ListNode listNode = new ListNode(array[0]);
        ListNode head = listNode;
        for (int i = 1; i < array.length ; i++) {
            listNode.next = new ListNode(array[i]);
            listNode = listNode.next;
        }

        new ReverseBetween().reverseBetween(head, 1, 1);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // 使用栈反序
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();

        int idx = 1;

        ListNode leftBegin = null;
        ListNode rightEnd = null;

        while(node != null) {
            if (idx == m - 1) {
                leftBegin = node;
            }
            if (idx == n + 1) {
                rightEnd = node;
            }
            if (idx >= m && idx <= n) {
                stack.push(node);
            }
            node = node.next;
            if (idx > n) {
                break;
            }
            idx++;
        }


        while(!stack.isEmpty()) {
            leftBegin.next = stack.pop();
            leftBegin = leftBegin.next;
        }
        leftBegin.next = rightEnd;
        return head;

    }
}
