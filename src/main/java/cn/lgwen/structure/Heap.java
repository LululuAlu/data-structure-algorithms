package cn.lgwen.structure;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/8/5
 * 若树中的节点的索引为x，则父节点的下标为（x-1）/2
 * 左子树节点的下标为 2x + 1
 * 右子树节点的下标为 2(x + 1)
 */
public class Heap {

    private Node[] nodes;

    private int max = 0;

    private int current = 0;


    public Heap(int len) {
        int l = 0;
        while (Math.pow(2, l) < len) {
            len++;
        }
        max = (int) Math.pow(2, l);
        nodes = new Node[max];
    }


    public int insert(int key, int value) {
        if (current >= max) {
            return -1;
        }
        Node newNode = new Node(key, value);
        // 直接插入到最后
        nodes[++current] = newNode;
        // 从最后向上逐个比较
        return trickleUp(current);
    }

    private int trickleUp(int current) {
        int parentIdx = (current - 1) / 2;
        Node currentNode = nodes[current];
        // 如果小于当前插入节点就一直往上寻找正确的节点
        while (current > 0 && nodes[parentIdx].key < currentNode.key) {
            nodes[current] = nodes[parentIdx];
            current = parentIdx;
            parentIdx = (current - 1) / 2;
        }
        // 使用复制算法，减少移动替换
        nodes[current] = currentNode;
        return 0;
    }


    public Node remove() {
        // 从数组第一个位置删除
        Node head = nodes[0];
        // 最后一个位置移动到第一个位置
        nodes[0] = nodes[current--];
        // 向下查找到一个 合适的位置，比上不足比下有余
        trickleDown(0);
        return head;
    }

    /**
     * @param idx 需要比较的key
     * @return
     */
    private void trickleDown(int idx) {
        // 先找出左右子树，比较左右子树和当前key的大小
        int largeChildIdx;

        Node top = nodes[idx];
        //
        while (idx < current / 2 && nodes[idx] != null) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            // 左子树
            if (right < current &&
                    // 感觉这里不用比较，必定是存在的
                    // 需要判断空
                    nodes[right].key > nodes[left].key) {
                largeChildIdx = right;
            } else {
                largeChildIdx = left;
            }
            if (top.key >= nodes[largeChildIdx].key) {
                break;
            }
            nodes[idx] = nodes[largeChildIdx];
            idx = largeChildIdx;
        }
        nodes[idx] = top;
        //
    }

    private static class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int key;
        int value;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
