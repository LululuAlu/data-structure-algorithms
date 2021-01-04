package cn.lgwen.sort;

import cn.lgwen.arithmetic.MergeTwoLists;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

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


    @Test
    public void linkedMap() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("s", 3);
        map.put("h", 4);
        map.put("f", 5);
        for (Iterator<Integer> it = map.values().iterator(); it.hasNext(); ) {
            System.out.print(it.next());
            System.out.print(",");
        }
        System.out.println();
        map.get("b");
        for (Iterator<Integer> it = map.values().iterator(); it.hasNext(); ) {
            System.out.print(it.next());
            System.out.print(",");
        }
        System.out.println();
        map.put("h", 4);
        for (Iterator<Integer> it = map.values().iterator(); it.hasNext(); ) {
            System.out.print(it.next());
            System.out.print(",");
        }
    }

    @Test
    public void and() {
        int a = 16;
        int b = 3;
        int c = 20;
        System.out.println(b&a);
        System.out.println(c&a);
    }
}