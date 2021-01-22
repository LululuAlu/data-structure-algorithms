package cn.lgwen;

import java.util.Arrays;

/**
 * 2020/12/28
 * aven.wu
 * danxieai258@163.com
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{5,1,2,4,5};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    static public void sort(int[] arrays) {
        mergeSort(arrays, 0, arrays.length - 1);
    }


    static public void mergeSort(int[] arrays, int start, int end) {
        if (start == end) return;
        int middle = (start + end) / 2;
        mergeSort(arrays, start, middle);
        mergeSort(arrays, middle + 1, end);
        merge(arrays, start, middle, end);
    }

    static public void merge(int[] arrays, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid+1, idx=0;
        while (i <= mid && j <= end) {
            if (arrays[i] < arrays[j]) {
                tmp[idx++] = arrays[i++];
            } else {
                tmp[idx++] = arrays[j++];
            }
        }
        while (i <= mid){
            tmp[idx++] = arrays[i++];
        }
        while (j <= end){
            tmp[idx++] = arrays[j++];
        }
        System.arraycopy(tmp, 0, arrays, start, end - start + 1);
    }
}
