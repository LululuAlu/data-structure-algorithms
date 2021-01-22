package cn.lgwen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2020/12/29
 * aven.wu
 * danxieai258@163.com
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arrays = new int[]{3,4,2,1,4,5,2,};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    static public void sort(int[] arrays) {
        // 1 构建大顶堆
        buildMaxHeap(arrays, arrays.length);
        // 交换堆顶和当前末尾的节点，重置大顶堆
        int len = arrays.length;
        for (int i = len - 1; i >= 0; i--) {
            swap(arrays, 0, i);
            len--;
            heapify(arrays, 0, len);
        }
    }

    static void buildMaxHeap(int[] arrays, int len){
        // 从最后一个非叶节点开始向前遍历，调整节点性质，使之成为大顶堆
        // 第一个非叶子节点,
        int idx = len / 2 - 1;
        // 从 0 -> idx 都是非也子节点
        for (int i = idx; i >= 0; i--) {
            heapify(arrays, i, len);
        }
    }

    static private void heapify(int[] arrays, int i, int len) {
        int leftLeaf = 2 * i + 1;
        int rightLeaf = 2 * (i + 1);
        int lastIdx = i;
        // 防止越界
        if (leftLeaf < len && arrays[leftLeaf] > arrays[lastIdx]) {
            // 左子树大于根，进行交换
            lastIdx = leftLeaf;
        }
        if (rightLeaf < len && arrays[rightLeaf] > arrays[lastIdx]) {
            lastIdx = rightLeaf;
        }
        if (lastIdx != i) {
            // 说明被交换过，则需要交换根和对应 左子树或者右子树的位子
            swap(arrays, i, lastIdx);
            // 因为交换了 lastIdx(left | right) 位置的数。所以需要重新构建一次 大顶堆
            heapify(arrays, lastIdx, len);
        }
    }

    static private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
