package cn.lgwen.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/7/28
 */
public class BinaryTree {

    Node root;


    void insert(int key, int value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        Node current = root;
        while (true) {
            int tmpKey = current.key;
            if (key == tmpKey) {
                current.value = value;
            }
            // 小于，往左边找
            if (key < current.key) {
                if (current.left == null) {
                    current.left = new Node(key, value);
                    return;
                }
                current = current.left;
                continue;
            }
            // 大于，往右边找
            if (key > current.key) {
                if (current.right == null) {
                    current.right = new Node(key, value);
                    return;
                }
                current = current.right;
            }
        }
    }

    Node get(int key) {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (true) {
            int tmpKey = current.key;
            if (key == tmpKey) {
                return current;
            }
            // 小于，往左边找
            if (key < current.key) {
                if (current.left == null) {
                    return null;
                }
                current = current.left;
                continue;
            }
            // 大于，往右边找
            if (current.right == null) {
                return null;
            }
            current = current.right;
        }
    }

    void traversal() {
        inOrder(root);
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node);
            inOrder(node.right);
        }
    }

    void perOrder(Node node) {
        if (node != null) {
            System.out.println(node);
            inOrder(node.left);
            inOrder(node.right);
        }
    }

    void afterOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            inOrder(node.right);
            System.out.println(node);
        }
    }


    boolean delete(int key) {
        // 三种情况
        // 1 要删除的节点没有子节点
        // 2 要删除的节点只有一个子节点
        // 3 要删除的节点有两个子节点
        // 1
        Node node = get(key);
        if (node == null) {
            return false;
        }
        if (node.right == null && node.left == null){
            node = null;
            return true;
        }
        // 2
        if (node.left != null && node.right == null) {
            node = node.left;
            return true;
        }
        if (node.left == null) {
            node = node.right;
            return true;
        }
        // 3  找到要删除节点的右子节点中最小的节点，作为当前节点
        // 两种情况，3.1右子节点有左节点，3.2右子节点没有左节点

        Node root = node.right;//当前删除节点的右子节点
        if (root.left == null) {
            // 3.1 的情况，右子节点升上来，为当前节点
            root.left = node.left;
            node = root;
        } else {
            //
            Node current = root.left;
            Node parent = current;
            while (current != null) {
                parent = current;
                current = current.left;
            }
            node.key = parent.key;
            node.value = parent.value;
            parent = null;
            return true;
        }
        return false;
    }



    private static class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int key;
        int value;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1, 343);
        tree.insert(5, 342);
        tree.insert(2, 341);
        tree.insert(8, 344);
        tree.insert(29, 0);
        tree.traversal();
        tree.delete(5);
        tree.traversal();

        int[] res = new int[1];
    }
}
