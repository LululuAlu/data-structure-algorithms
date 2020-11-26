package cn.lgwen.arithmetic;

import java.util.List;
import java.util.Stack;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/10/19
 */
public class ExclusiveTime {

    public static void main(String[] args) {
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] timeArray = new int[n];
        int expend = 0;
        Stack<Integer> stack = new Stack<>();
        for(String log : logs) {
            String[] subArray = log.split(":");
            int idx = Integer.parseInt(subArray[0]);
            int time = Integer.parseInt(subArray[2]);
            if ("start".equals(subArray[1])) {
                // 如果是start 就入栈
                stack.push(time);
            } else {
                // 出栈一个
                int expendTime = time - stack.pop() - expend + 1;
                timeArray[idx] = expendTime;
                expend = expendTime;
            }
        }
        return timeArray;
    }
}
