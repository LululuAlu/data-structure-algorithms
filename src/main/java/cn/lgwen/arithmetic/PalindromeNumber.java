package cn.lgwen.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020/4/21
 * aven.wu
 * danxieai258@163.com
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-10));
        System.out.println(isPalindrome(11));
        System.out.println(isPalindrome(9));
        System.out.println(isPalindrome(0));
    }


    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int n = x;
        for (int i = 0; n != 0; i++) {
            map.put(i, n % 10);
            n = n / 10;
        }
        // 奇数
        if (map.size() % 2 != 0) {
            for (int i = 0; i < map.size() / 2 + 1; i++) {
                if (!map.get(i).equals(map.get(map.size() -1  - i))) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < map.size() / 2; i++) {
            if (!map.get(i).equals(map.get(map.size() - i - 1))) {
                return false;
            }
        }
        // 奇数
        return true;
    }
}
