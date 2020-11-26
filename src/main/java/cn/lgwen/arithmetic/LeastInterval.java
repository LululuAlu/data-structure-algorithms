package cn.lgwen.arithmetic;

import java.util.Arrays;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/11/19
 * 621. 任务调度器
 */
public class LeastInterval {


    public static void main(String[] args) {
        int res = new LeastInterval().leastInterval(new char[]{'A','A','A','B',
                'B','C','C','D','E','E','E','F','G','G'}, 4);
        System.out.println(res);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);


        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
}
