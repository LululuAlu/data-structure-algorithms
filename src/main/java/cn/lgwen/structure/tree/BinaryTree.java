package cn.lgwen.structure.tree;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/7/28
 * 二叉树
 */
public class BinaryTree {

    Node root;

    void insert(int key, int value) {
        if (root == null) {
            root = new Node(key, value, null);
            return;
        }
        Node current = root;
        Node parent;
        while (true) {
            // 当前可以相等，直接覆盖。
            int tmpKey = current.key;
            if (key == tmpKey) {
                current.value = value;
            }
            parent = current;
            // 小于，往左边找
            if (key < current.key) {
                if (current.left == null) {
                    current.left = new Node(key, value, parent);
                    return;
                }
                current = current.left;
                continue;
            }
            // 大于，往右边找
            if (key > current.key) {
                if (current.right == null) {
                    current.right = new Node(key, value, parent);
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
        //inOrder(root);
        perOrder(root);
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
        // 2 要删除的节点只有一个子节点,
        // 3 要删除的节点有两个子节点

        // 1 直接删除
        Node delNode = get(key);
        if (delNode == null) {
            return false;
        }

        if (delNode.right == null && delNode.left == null) {
            Node parent = delNode.parent;
            if (parent.left.key == key) {
                parent.left = null;
            } else parent.right = null;
            return true;
        }
        // 2 只有一个节点，子节点升上来接替被删除的节点
        if (delNode.left != null && delNode.right == null) {
            Node leftChild = delNode.left;
            Node parent = delNode.parent;
            leftChild.parent = parent;
            parent.left = leftChild;
            return true;
        }
        if (delNode.left == null) {
            Node rightChild = delNode.right;
            Node parent = delNode.parent;
            rightChild.parent = parent;
            parent.right = rightChild;
            return true;
        }

        // 3  找到要删除节点的右子节点中最小的节点，作为当前节点
        // 两种情况，
        // 3.1右子节点没有左节点，直接升上来顶替父节点
        // 3.2右子节点有左节点，一直往左寻找，直到找到一个左节点。
        Node root = delNode.right;//当前删除节点的右子节点
        Node parent = delNode.parent;
        // 3.1 的情况，右子节点升上来，为当前节点
        if (root.left == null) {
            root.left = delNode.left;
            if (parent.left != null && parent.left.key == key) {
                // 删除的是左节点，
                parent.left = root;
            } else {
                parent.right = root;
            }
            root.parent = parent;
        } else {
            // 右子节点有左节点，一直往左寻找，直到找到一个左节点
            Node current = root.left;
            Node noNullLeftNode = current;
            while (current != null) {
                noNullLeftNode = current;
                current = current.left;
            }
            // 找到最左的节点，parent
            // 如果当前不是子节点 right != null
            // 当前子节点顶替当前节点
            if (noNullLeftNode.right != null) {
                noNullLeftNode.parent.left = noNullLeftNode.right;
            }
            if (parent.left != null && parent.left.key == key) {
                // 删除的是左节点，
                parent.left = noNullLeftNode;
            } else {
                parent.right = noNullLeftNode;
            }
            noNullLeftNode.parent = parent;
            noNullLeftNode.left = delNode.left;
            noNullLeftNode.right = delNode.right;
            return true;
        }
        return false;
    }



    private static class Node {
        public Node(int key, int value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        int key;
        int value;
        Node parent;
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
        tree.insert(5, 343);
        tree.insert(2, 342);
        tree.insert(8, 341);
        tree.insert(6, 344);
        tree.insert(12, 0);
        tree.insert(10, 0);
        tree.insert(11, 0);
        tree.insert(13, 0);
        tree.insert(15, 0);
        tree.traversal();
        System.out.println("delete key");
        tree.delete(12);
        tree.traversal();

        int[] res = new int[1];
    }
}
