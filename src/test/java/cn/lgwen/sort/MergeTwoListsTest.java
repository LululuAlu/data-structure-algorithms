package cn.lgwen.sort;

import org.junit.Test;

public class MergeTwoListsTest {

    @Test
    public void test1() {
        MergeTwoLists.ListNode l3 = new MergeTwoLists.ListNode(2);

        MergeTwoLists.ListNode n1 = new MergeTwoLists.ListNode(5);
        MergeTwoLists.ListNode n2 = new MergeTwoLists.ListNode(3);
        MergeTwoLists.ListNode n3 = new MergeTwoLists.ListNode(1);
        n3.next = n2;
        n2.next = n1;

        print(MergeTwoLists.mergeTwoLists(l3, n3));
    }

    @Test
    public void test2() {
        MergeTwoLists.ListNode l3 = new MergeTwoLists.ListNode(2);

        MergeTwoLists.ListNode n3 = new MergeTwoLists.ListNode(3);
        print(MergeTwoLists.mergeTwoLists(l3, n3));
    }

    private void print(MergeTwoLists.ListNode res) {
        while (res.next != null) {
            System.out.print(res.val);
            System.out.print(",");
            res = res.next;
        }
    }

}