package cn.lgwen.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/7/27
 * 快速排序
 */
public class Quick {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 4, 2, 6, 5, 7, 9, 1, 8, 7};
        new Quick().sort(a, Integer::compareTo);
        System.out.println(Arrays.toString(a));
    }

    public <T> void sort(T[] arrays, Comparator<T> comparator) {
        quickSort(arrays, comparator, 0, arrays.length - 1);

    }

    public <T> void quickSort(T[] arrays, Comparator<T> comparator, int start, int end) {
        // 先取第一个数作为中间数
        if (start >= end) {
            return;
        }
        T pivot = arrays[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && comparator.compare(arrays[j], pivot) >= 0) { // 从右往左 寻找第一个小于 pivot的数
                j--;
            }
            if (i < j) { // 找到的数放在 第一个空出来的i的位置
                arrays[i++] = arrays[j];
            }
            while (i < j && comparator.compare(arrays[i], pivot) < 0) { // 从左网右找第一个大于 pivot的数
                i++;
            }
            if (i < j) { // 找到的数放在 第二个空出来的j的位置
                arrays[j--] = arrays[i];
            }
        }
        // 找到 pivot 存放的位置
        arrays[i] = pivot;
        quickSort(arrays, comparator, start, i - 1);
        quickSort(arrays, comparator, i + 1, end);

    }
}
