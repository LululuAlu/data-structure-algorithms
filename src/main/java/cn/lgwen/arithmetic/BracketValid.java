package cn.lgwen.arithmetic;

import cn.lgwen.structure.Stack;

/**
 * 2020/4/27
 * aven.wu
 * danxieai258@163.com
 */
public class BracketValid {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("]}"));

    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char v = stack.pop();
                if (c == '}' && v != '{') {
                    return false;
                }
                if (c == ')' && v != '(') {
                    return false;
                }
                if (c == ']' && v != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
