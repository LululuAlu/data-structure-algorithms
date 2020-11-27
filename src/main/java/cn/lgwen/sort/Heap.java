package cn.lgwen.sort;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/10/14
 * 堆排序
 */
public class Heap {

    public static void main(String[] args) {
        new Heap().findKthLargest(new int[]{3,4,2,1,4,5,2,}, 0);
    }

    public int findKthLargest(int[] arr, int k) {
        int len = arr.length;

        buildMaxHeap(arr, len);

        // 交换堆顶和当前末尾的节点，重置大顶堆
        for (int i = len - 1; i > 0; i--) {
            // 交换 堆定和 尾部 最后一个未排序的位置
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return 0;
    }

    // 构建大顶堆
    private void buildMaxHeap(int[] arr, int len) {
        // 从最后一个非叶节点开始向前遍历，调整节点性质，使之成为大顶堆
        for (int i = (int) Math.floor(len / 2) - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        //找出佐佑子树
        int leftIdx = 2 * i + 1;
        int rightIdx = 2 * i + 2;
        int largestIdx = i;

        // 如果左子树大于根节点则进行交换
        if (leftIdx < len && arr[leftIdx] > arr[largestIdx]) {
            largestIdx = leftIdx;
        }
        // 如果右子树大于根节点则进行交换
        if (rightIdx < len && arr[rightIdx] > arr[largestIdx]) {
            largestIdx = rightIdx;
        }
        if (largestIdx != i) {
            // 说明被交换过，则需要交换根和对应 左子树或者右子树的位子
            swap(arr, i, largestIdx);

            // 因为被交换了，所以对应 已 largestIdx下标为根的 左 根 右 也要进行一次排序。
            heapify(arr, largestIdx, len);
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
