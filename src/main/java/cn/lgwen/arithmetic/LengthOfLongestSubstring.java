package cn.lgwen.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/9/4
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab") == 2);
        System.out.println(lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(lengthOfLongestSubstring("dvdf") == 3);

    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charset = new HashMap<>();
        int len = 0;
        int start = 0;
        for(int end = 0; end < s.length(); end++) {
            if (charset.containsKey(s.charAt(end))) {
                start = Math.max(start, charset.get(s.charAt(end)));
            }
            len = Math.max(len, end - start + 1);
            charset.put(s.charAt(end), end + 1);
        }
        return len;
    }
}
