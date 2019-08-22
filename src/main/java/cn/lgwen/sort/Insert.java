package cn.lgwen.sort;

import java.util.Comparator;

/**
 * create by wuxuyang on 2019/8/20
 */
public class Insert {

    public static <T> T[] sort(T[] arrays, Comparator<T> comparator) {
        for (int i = 1; i < arrays.length; i++) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(arrays[i], arrays[j]) < 0) {
                    // arrays[i] 要插入到 有序部分，
                    insert(arrays, j, i);
                }
            }
        }
        return arrays;
    }

    private static <T> void insert(T[] arrays, int a, int b) {
        T tmp = arrays[b];
        for (int i = b; i > a; i--) {
            arrays[i] = arrays[i-1];
        }
        arrays[a] = tmp;
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
