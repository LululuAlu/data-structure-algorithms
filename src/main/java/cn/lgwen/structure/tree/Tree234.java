package cn.lgwen.structure.tree;


/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/7/30
 */
public class Tree234 {
    Node root = new Node();


    public void insert(DataItem item) {
        Node current = root;
        while (true) {
            // 如果当前节点满了 就要进行拆分
            if (current.isFull()) {
                split(current);
                // 拆分后当前节点会变成子节点 所以先获取其父节点，然后重新开始查询
                current = current.getParent();
                //找到一个 当前值可以插入节点（可能是父节点，可能是叶子节点）
                current = getNextChild(current, item);
            } else if (current.isLead()) { //当前节点是叶子节点 找到要插入的node 直接插入
                break;
            } else {
                current = getNextChild(current, item);
            }
        }
        current.insertItem(item);
    }

    //
    private Node getNextChild(Node current, DataItem item) {
        int len = current.nodes;
        int i;
        for (i = 0; i < len; i++) {
            if (item.data < current.items[i].data) {
                return current.child[i];
            }
        }
        return current.child[i];
    }

    private void split(Node current) {
        //
        DataItem item2, item3;
        // 分别对应 2 1 3 位置的item
        Node parent, child1, child2;
        item3 = current.removeMax();
        item2 = current.removeMax();

        child1 = current.disConnect(2);
        child2 = current.disConnect(3);

        if (current == root) { // 如果要拆分的节点为根的话
            root = new Node();  // 创建一个新的根
            parent = root;      // 父节点等于新的根
            root.connectChild(0, current); // 然后让新的根节点与之前的节点相连 连在最左边的位置上
            //
        } else {
            parent = current.getParent();
        }
        // 分裂的中间值给 parent
        parent.insertItem(item2);


        int n = parent.nodes;
        for (int j = n - 1; j > n; j--) { //
            // 所有parent的node 都要向后移动一位，然后空出第一位留给， 之前分裂的节点的中间节点
            Node temp = parent.disConnect(j);
            parent.connectChild(j + 1, temp);
        }
        //链接上之前分裂的节点（现在成了左1节点）
        parent.connectChild(0, current);

        Node newRight = new Node();
        // 之前分裂节点的最大值放大右节点中
        newRight.insertItem(item3);
        newRight.connectChild(0, child1);
        newRight.connectChild(1, child2);
        // 创建一个right节点。链接上以之前分列的右2 3节点作为子节点的节点。
        parent.connectChild(1, newRight);
    }


    class DataItem {
        long data;

        @Override
        public String toString() {
            return "/" + data;
        }
    }

    class Node {
        int nodes;
        Node Parent;
        Node[] child = new Node[4];
        DataItem[] items = new DataItem[3];

        public boolean isFull() {
            return true;
        }

        public void insertItem(DataItem item) {
            // 找到合适的位置插入
            for (int i = 0; i < 3; i++) {
                if (items[i] == null) {
                    items[i] = item;
                    return;
                }
                if (item.data < items[i].data) {
                    // 插入到当前位置
                    DataItem tmp = items[i];
                    DataItem perValue;
                    items[i++] = item;
                    while (i < nodes) {
                        perValue = items[i];
                        items[i] = tmp;
                        tmp = perValue;
                    }
                }
            }
        }

        public Node getParent() {
            return null;
        }

        public boolean isLead() {
            return true;
        }

        // 返回当前最大值
        public DataItem removeMax() {
            return null;
        }

        public Node disConnect(int i) {
            Node node = child[i];
            child[i] = null;
            return node;
        }

        public void connectChild(int i, Node current) {
        }
    }
}
