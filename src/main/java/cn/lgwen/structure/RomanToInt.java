package cn.lgwen.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020/4/22
 * aven.wu
 * danxieai258@163.com
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        char per = 0;
        for (char c : chars) {
            if (per == 0) {
                per = c;
                sum += getValue(c);
                continue;
            }
            // 上一个小于当前这一个，就减去上一个值，并加上当前值减去上一个值
            if (getValue(per) < getValue(c)) {
                sum -= getValue(per) * 2;
                sum = sum + getValue(c);
            } else {
                sum += getValue(c);
            }
            per = c;

        }
        return sum;
    }
    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
