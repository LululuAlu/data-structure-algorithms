package cn.lgwen.sort;

import java.util.Comparator;

/**
 * create by wuxuyang on 2019/8/20
 * 冒泡排序
 */
public class Bubble {


    public static <T> T[] bubbleSort(T [] arrays, Comparator<T> comparator) {
        for(int i = arrays.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(arrays[j], arrays[j + 1]) > 0) {
                    swap(arrays, j, j + 1);
                }
            }
        }
        return arrays;
    }

    private static <T> void swap (T[] arrays, int a, int b) {
        T tmp = arrays[a];
        arrays[a] = arrays[b];
        arrays[b] = tmp;
    }


    public static void main(String[] args) {
        Integer[] a = {1,0,192,-201,9,-10};
        Integer[] b = bubbleSort(a, Integer::compareTo);
        for (int i : b) {
            System.out.print(i);
            System.out.print(",");
        }
    }
}
