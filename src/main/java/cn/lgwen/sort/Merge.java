package cn.lgwen.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/7/21
 * 归并排序
 */
public class Merge {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 4, 2, 6, 5, 7, 9, 1, 8, 7};
        sort(a, Integer::compareTo);
        System.out.println(Arrays.toString(a));
    }

    public static <T> void sort(T[] arrays, Comparator<T> comparator) {
        mergeSort(arrays, 0, arrays.length - 1, comparator);
    }

    private static <T> void mergeSort(T[] arrays, int start, int end, Comparator<T> comparator) {
        if (end == start) {
            return;
        }
        int mid = (end + start) / 2 ;
        mergeSort(arrays, start, mid, comparator);
        mergeSort(arrays, mid + 1, end, comparator);
        merge(arrays, start, mid, end, comparator);
    }

    private static <T> void merge(T[] arrays, int start, int mid, int end, Comparator<T> comparator) {
        Object[] tmp = new Object[end - start + 1];
        int i = start;
        int j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= end) {
            if (comparator.compare(arrays[i], arrays[j]) < 0) {
                tmp[idx++] = arrays[i];
                i++;
            } else {
                tmp[idx++] = arrays[j];
                j++;
            }
        }
        if (i <= mid) {
            for (; i <= mid; i++) {
                tmp[idx++] = arrays[i];
            }
        }
        if (j <= end) {
            for (; j <= end;) {
                tmp[idx++] = arrays[j++];
            }
        }
        System.arraycopy(tmp, 0, arrays, start, end - start + 1);
    }
}
