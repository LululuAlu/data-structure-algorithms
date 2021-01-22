package cn.lgwen;

import java.util.Arrays;

/**
 * 2020/12/28
 * aven.wu
 * danxieai258@163.com
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] a = new int[]{5, 1, 2, 4, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }


    public static void quickSort(int[] array, int start, int end) {
        //
        if (start >= end) return;
        int pivot = array[start];

        int i = start;
        int j = end;
        while (i < j) {
            // 从右往左找一个比当前pivot小的数
            while (i < j && array[j] < pivot) j--;
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            // 从左往右找一个比 pivot大的
            while (i < j && array[i] > pivot) i++;
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = pivot;

        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);

    }
}
