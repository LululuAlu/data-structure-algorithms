package cn.lgwen.arithmetic;

import java.util.Arrays;

/**
 * 2020/11/30
 * aven.wu
 * danxieai258@163.com
 * 908. 最小差值 I
 */
public class SmallestRangeI {

    public static void main(String[] args) {
        int i = new SmallestRangeI().smallestRangeI(new int[]{3,1,10}, 4);
        System.out.println(i);
    }

    public int smallestRangeI(int[] A, int k) {
        int total = 0;
        for (int i : A) {
            total += i;
        }
        int avg = total / A.length;


        for (int i = 0; i < A.length; i++) {
            int current = A[i];
            if (current < avg) {
                int tmp = Math.min(current + k, avg);
                A[i] = tmp;
            } else {
                int tmp = Math.max(current - k, avg);
                A[i] = tmp;
            }
        }
        Arrays.sort(A);
        return A[A.length - 1] - A[0];
    }
}
