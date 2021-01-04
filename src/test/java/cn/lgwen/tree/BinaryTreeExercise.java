package cn.lgwen.tree;

/**
 * @Author aven.wu
 * @Date 2020/12/30
 */
public class BinaryTreeExercise {

    private Node root;

    public BinaryTreeExercise() {
    }


    public void put(int key, Object val) {
        if (root == null) {
            root = new Node(key, val);
            return;
        }
        Node currentNode = root;
        Node per = null;
        while (currentNode != null) {
            per = currentNode;
            if (currentNode.key < key) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        if (key < per.key) {
            per.left = new Node(key, val);
        } else {
            per.right = new Node(key, val);
        }
    }

    public Object get(int key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.key == key) return currentNode.val;
            if (currentNode.key < key) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        return null;
    }

    public boolean delete(int key) {
        // delete 几种情况
        // 1 删除的节点是叶子节点
        // 2 删除的节点有一个节点
        // 3 删除的节点有两个节点
        if (root == null) return false;
        Node next = root;
        Node parent = null;
        Node current = null;
        while (next != null) {
            current = next;
            if (next.key == key)
                break;
            if (next.key < key) {
                next = next.right;
            } else {
                next = next.left;
            }
            parent = current;
        }
        if (parent == null) {
            root = null;
            return true;
        }
        //1
        if (isLeaf(current)) {
            if (parent.left.key == key) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // 2 移除当前节点，然后将子节点 连接到当前节点上
        if (current.right == null || current.left == null) {
            Node child;
            if (current.right == null) {
                child = current.left;
            } else {
                child = current.right;
            }

            if (key < parent.key) {
                //左
                parent.left = child;
            } else {
                //右
                parent.right = child;
            }
        }
        // 找到删除节点的最小左节点


        Node left = current.left;
        Node per = left;
        while (left != null) {
            per = left;
            if (left.left == null) break;
            left = left.left;
        }
        // 1 找到的节点是叶子节点，
        if (isLeaf(left)) {
            per.left = null;
            left.left = current.left;
            left.right = current.right;
            if (key < parent.key) {
                //左
                parent.left = left;
            } else {
                //右
                parent.right = left;
            }
        } else {
            // 找到的节点不是叶子节点
            // 将当前节点一移动到被删除的节点，然后将当前节点的右子节点，替代当前节点


        }




        return false;
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private static class Node {
        public int key;

        public Object val;

        public Node left;

        public Node right;


        public Node(int key, Object val) {
            this.key = key;
            this.val = val;
        }
    }
}
