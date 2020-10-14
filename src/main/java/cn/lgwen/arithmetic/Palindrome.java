package cn.lgwen.arithmetic;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/8/31
 */
public class Palindrome {

    public static void main(String[] args) {
        String str = "OP";
        System.out.println(isPalindrome(str));

    }

    public static boolean isPalindrome(String s) {
        if("".equals(s)) return true;
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while(i < j) {
            while(i <j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            int headStr = s.charAt(i);

            while(i <j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            int tailStr = s.charAt(j);
            if (i < j) {
                if (headStr != tailStr) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
