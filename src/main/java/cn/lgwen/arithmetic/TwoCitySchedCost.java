package cn.lgwen.arithmetic;

import java.util.Arrays;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/11/24
 * 1029. 两地调度
 */
public class TwoCitySchedCost {

    public static void main(String[] args) {
        new TwoCitySchedCost().twoCitySchedCost(new int[][]{{10,20}, {30,200}, {400,50}, {30,20}});
    }

    public int twoCitySchedCost(int[][] costs) {
        // 假设所有人都飞往一个地方A，然后让一部分人飞往B 当 飞往B 比 飞往 A花费更少时
        // 则飞B
        Arrays.sort(costs, (x, y) ->
                x[0] - x[1] - (y[0] - y[1])
        );


        int n = costs.length / 2;
        // 让一半的人飞往A
        // 一半的人飞B
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }
}
