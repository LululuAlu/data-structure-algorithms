package cn.lgwen.arithmetic;


import java.util.Stack;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/10/15
 */
public class RemoveKdigits {

    public static void main(String[] args) {
        System.out.println(new RemoveKdigits().removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stck = new Stack<>();
        int len = k;
        for (char c : num.toCharArray()) {
            if (c != '0' && stck.isEmpty()) {
                stck.push(c);
                continue;
            }
            if (stck.peek() > c) {
                len--;
                stck.pop();
                stck.push(c);
                continue;
            }
            stck.push(c);
        }
        while (len > 0) {
            len--;
            stck.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stck.size(); i++) {
            sb.append(stck.get(i));
        }
        return sb.toString();
    }
}
