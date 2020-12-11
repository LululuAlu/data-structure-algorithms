package cn.lgwen.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2020/11/29
 * aven.wu
 * danxieai258@163.com
 * 910. 最小差值 II
 */
public class SmallestRangeII {

    public static void main(String[] args) {
       int i =  new SmallestRangeII().smallestRangeII(new int[]{0, 10}, 2);
        System.out.println(i);
    }

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        // 要求最小值和最大值的差值
        // 设 i 为分割 则 0 - （i-1） 都 +K ，而 （i+1）- length 都 -K
        // 那问题变成求解 i  而新数组的 最小值 在A[0] - A[i - 1] 之间产生
        // 最大值在 A[i + 1] - A[length - 1] 之间产生
        // 尝试 第i个元素前每个元素+K,第i个元素(包括i)每个元素-K
        int len = A.length;
        if (len == 1) {
            return 0;
        }
        int res = A[len - 1] - A[0];

        for (int i = 0; i < len - 1; i++) {
            int max=Math.max(A[i]+K,A[len-1]-K);
            int min=Math.min(A[0]+K,A[i+1]-K);
            res = Math.min(res, max - min);
        }
        return res;


    }
}
