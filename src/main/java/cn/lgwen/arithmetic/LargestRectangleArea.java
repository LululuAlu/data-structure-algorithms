package cn.lgwen.arithmetic;

import cn.lgwen.structure.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/8/27
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(solution(heights));
        //System.out.println(largestRectangleArea(heights));
    }


    public static int solution(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                continue;
            }
            // 遇到比 栈顶元素小的 就可以触发计算，
            if (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    // 处理 两个高度相同的节点
                    int curHeight = heights[stack.pop()];
                    /*while (!stack.isEmpty() && heights[stack.peek()] == curHeight) {
                        stack.pop();
                    }*/
                    int curWidth;
                    if (stack.isEmpty()) {
                        curWidth = i;
                    } else {
                        curWidth = i - stack.peek() - 1;
                    }
                    res = Math.max(res, curHeight * curWidth);
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = heights.length;
            } else {
                curWidth = heights.length - stack.peek() - 1;
            }
            res = Math.max(res, height * curWidth);
        }
        return res;
    }


    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }



}
