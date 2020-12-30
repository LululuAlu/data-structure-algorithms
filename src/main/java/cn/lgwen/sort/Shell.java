package cn.lgwen.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/7/25
 * 希尔排序
 */
public class Shell {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 4, 2, 6, 5, 7, 9, 1, 8, 7};
        sort(a, Integer::compareTo);
        System.out.println(Arrays.toString(a));
    }


    public static <T> void sort(T[] array, Comparator<T> comparator) {
        // 求h
        int h = 1;
        while (h <= array.length / 3) {
            h = 3 * h + 1;
        }
        for (; h > 0; h = (h - 1) / 3) {

            for (int outer = h; outer < array.length; outer++) {
                T tmp = array[outer];
                int inner = outer;
                while (inner > h - 1 && comparator.compare(array[inner - h], tmp) < 0) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = tmp;
            }
        }
    }
}
