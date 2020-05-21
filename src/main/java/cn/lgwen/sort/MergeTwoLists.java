package cn.lgwen.sort;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * 2020/5/7
 * aven.wu
 * danxieai258@163.com
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        l3.next = l2;
        l2.next = l1;

        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n3.next = n2;
        n2.next = n1;

        ListNode res = mergeTwoLists(l3, n3);

        while (res.next != null) {
            res = res.next;
            System.out.println(res.val);
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode res;
        ListNode nodeL;
        ListNode nodeR;
        ListNode head;
        if (l1.val <= l2.val) {
            res = new ListNode(l1.val);
            nodeL = l1.next;
            nodeR = l2;
        } else {
            res = new ListNode(l2.val);
            nodeL = l1;
            nodeR = l2.next;
        }
        head = res;
        while (nodeL != null || nodeR != null) {
            if (nodeL == null) {
                res.next = new ListNode(nodeR.val);;
                nodeR = nodeR.next;
            } else if (nodeR == null) {
                res.next = new ListNode(nodeL.val);
                nodeL = nodeL.next;
            } else if (nodeL.val <= nodeR.val) {
                res.next = new ListNode(nodeL.val);
                nodeL = nodeL.next;
            } else {
                res.next = new ListNode(nodeR.val);
                nodeR = nodeR.next;
            }
            res = res.next;
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


