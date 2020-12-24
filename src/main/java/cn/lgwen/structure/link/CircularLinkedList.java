package cn.lgwen.structure.link;

/**
 * @Author aven.wu
 * @Date 2020/12/24
 * 循环链表
 */
public class CircularLinkedList {
    private Node root;

    public CircularLinkedList() {
    }

    public void add(int element) {
        if (root == null) {
            root = new Node(element);
        }
        else {
            Node per = root;
            Node next = root.after;
            while (next != root) {
                per = next;
                next = next.after;
            }
            per.after = new Node(element, per);
            per.after.after = root;
            root.per = per.after;
        }
    }

    public void remove(int idx) {

    }

    private static class Node {

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node per) {
            this.val = val;
            this.per = per;
        }

        int val;
        Node per;
        Node after;
    }
}
