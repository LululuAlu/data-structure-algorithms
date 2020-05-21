package cn.lgwen.arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2020/4/21
 * aven.wu
 * danxieai258@163.com
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
public class OverturnNumber {

    public static void main(String[] args) {

        System.out.println(120);
        System.out.println(reverse(120));
        System.out.println(-9);
        System.out.println(reverse(-9));
        System.out.println(-1254789639);
        System.out.println(reverse(-1254789639));
        System.out.println(-1463847412);
        System.out.println(reverse(-1463847412));
    }

    public static int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        int res = 0;
        while (x != 0) {
            int remainder = x % 10;
            // 考虑溢出问题
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && remainder > 7))
                return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && remainder < -8))
                return 0;
            res = res * 10 + remainder;
            x = x / 10;
        }
        return res;
    }

}
