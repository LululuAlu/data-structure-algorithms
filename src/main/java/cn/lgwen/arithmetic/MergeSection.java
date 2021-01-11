package cn.lgwen.arithmetic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aven danxieai258@163.com
 * 2021/1/11
 * 56. 合并区间
 */
public class MergeSection {
    public static void main(String[] args) {
        new MergeSection().merge(new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        });
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int idx = 0;
        int len = intervals.length;
        int[][] res = new int[intervals.length][2];
        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] <= end) {
                end = intervals[i][1];
                continue;
            }
            // 中断 生成一个区间
            res[idx++] = new int[]{begin, end};
            begin = intervals[i][0];
            end = intervals[i][1];
        }
        res[idx++] = new int[]{begin, end};
        int[][] finalRes = new int[idx][2];
        System.arraycopy(res, 0, finalRes, 0, idx);
        return finalRes;
    }
}
