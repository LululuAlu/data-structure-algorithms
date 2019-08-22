package cn.lgwen.sort;

import java.util.Comparator;

/**
 * create by wuxuyang on 2019/8/20
 * 选择排序
 */
public class Select {

    public static  <T> T[] sort(T[] arrays, Comparator<T> comparable) {
        int minIndex;
        for (int i = 0; i < arrays.length - 1; i++) {
            minIndex = i;
            T min = arrays[i];
            for(int j = i + 1; j < arrays.length; j++) {
                if (comparable.compare(min, arrays[j]) > 0) {
                    minIndex = j;
                    min = arrays[j];
                }
            }
            swap(arrays, i, minIndex);
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
        Integer[] b = sort(a, Integer::compareTo);
        for (int i : b) {
            System.out.print(i);
            System.out.print(",");
        }
    }

}
