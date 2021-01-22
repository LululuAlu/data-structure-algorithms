package cn.lgwen.arithmetic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * 2020/12/28
 * aven.wu
 * danxieai258@163.com
 */
public class BinarySearch {

    public static void main(String[] args) {
        int i = mach(new int[]{1,2,3,4,5,6,7,8}, 0);
        System.out.println(i);
    }

    static int mach(int[] arrays, int target) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        if (arrays.length < 1) {
            return -1;
        }
        if (arrays.length == 1) return target == arrays[0] ? 0 : -1;

        int middle = arrays.length / 2;
        if (target == arrays[middle]) return middle;
        if (target > arrays[middle]) return match(arrays, middle + 1, arrays.length - 1, target);
        else return match(arrays, 0, middle - 1, target);

    }

    static int match(int[] arrays, int start, int end, int target) {
        if (start > end) return -1;
        if (start == end) return target == arrays[start] ? start : -1;

        int middle = (start + end) / 2;
        if (target == arrays[middle]) return middle;
        if (target > arrays[middle]) return match(arrays, middle + 1, end, target);
        else return match(arrays, 0, middle - 1, target);
    }
}
