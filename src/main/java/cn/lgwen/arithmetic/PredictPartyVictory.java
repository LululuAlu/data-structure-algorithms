package cn.lgwen.arithmetic;

import cn.lgwen.structure.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 2020/11/25
 * aven.wu
 * danxieai258@163.com
 * 649. Dota2 参议院
 */
public class PredictPartyVictory {


    public static void main(String[] args) {
        String ddrrr = new PredictPartyVictory().predictPartyVictory("DDRRR");
        System.out.println(ddrrr);
    }

    public String predictPartyVictory(String senate) {
        String D = "Dire";
        String R = "Radiant";

        // 使用栈，如果遇到空栈或者栈顶元素和自己相同则入栈，如果遇到不相同的则栈顶元素弹出，当前元素投票失败，栈顶元素放入胜利队列


        // 胜利队列
        Queue<Character> queue = new ArrayDeque<>();
        for(char c : senate.toCharArray()) {
            queue.add(c);
        }
        Stack<Character> stack = new Stack<>();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (stack.isEmpty() || stack.peek() == c) {
                //入栈
                stack.push(c);
            } else {
                // 放入投票胜利队列
                queue.add(stack.pop());
            }
        }
        return stack.pop() == 'R' ? R : D;
    }


    public String p1(String senate) {
        String D = "Dire";
        String R = "Radiant";
        // 如果有投票的权利 则优先禁用之后的 对方的人 因为后面的人才有机会禁用你
        int Dcnt = 0, Rcnt = 0;
        char[] toCharArray = senate.toCharArray();

        for(char c : senate.toCharArray()) {
            if ('D' == c) Dcnt++;
            else Rcnt++;
        }
        int current = senate.length();

        int Dchance = 0;
        int Rchance = 0;
        flag:
        while(true) {
            // 怎样才算一轮
            for(int i = 0; i < current; i++) {
                switch(toCharArray[i]) {
                    case '0':
                        continue;  // 表示被禁用权利了
                    case 'D':
                        // 查看当前这轮 还有没有 Rchance ，如果有的话就D会被他禁用
                        if (Rchance > 0) {
                            toCharArray[i] = '0';
                            Rchance--;
                            Dcnt--;
                        } else {
                            // 如果没有，则保存我禁用的能力
                            Dchance++;
                        }
                        break;
                    case 'R':
                        // 查看当前这轮 还有没有 Rchance ，如果有的话就D会被他禁用
                        if (Dchance > 0) {
                            toCharArray[i] = '0';
                            Dchance--;
                            Rcnt--;
                        } else {
                            // 如果没有，则保存我禁用的能力
                            Rchance++;
                        }
                        break;
                }
                // 满足一方赢的条件
                if (Dcnt == 0 || Rcnt == 0) break flag;
            }

        }
        return Dcnt > 0 ? D : R;
    }

}
