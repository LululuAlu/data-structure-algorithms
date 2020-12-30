package cn.lgwen.arithmetic;

/**
 * @Author aven.wu
 * @Date 2020/12/28
 * 5. 最长回文子串
 */
public class LongestPalindrome {


    // 中心扩散的动态规划
    /**
     * 我们用一个 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文。试想如果 dp[l][r]=true，
     * 我们要判断 dp[l-1][r+1] 是否为回文。只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符，
     * @param s 'babad'
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                // l == r 并且 l+1 ~ r-1 是回文串
                if (s.charAt(l) == s.charAt(r) && (dp[l+1][r-1] || r - l <= 2)) { // r-l <= 2 说明只有两个以内的元素，要么相同要么就只有一个
                    dp[l][r] = true;
                    // 更新当前位置的最长串
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
