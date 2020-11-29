package cn.lgwen.structure;

/**
 * 2020/4/25
 * aven.wu
 * danxieai258@163.com
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arys = new String[] {"c","c"};
        String[] arys1 = new String[] { "flower","flow","flight"};

        System.out.println(longestCommonPrefix(arys));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return  "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int len = strs[0].length();
        int idx = 0;
        for (int i = 1; i < strs.length; i++) {
            if (len > strs[i].length()) {
                len = strs[i].length();
                idx = i;
            }
        }
        String sortString = strs[idx];
        int lenth = 0;
        a:for (int i = 0; i < len; i++) {
            for (String s : strs) {
                if (s.charAt(i) != sortString.charAt(i)) {
                    lenth = i;
                    break a;
                }
            }
            // 所有下标都标记通过
            lenth++;
        }
        return sortString.substring(0, lenth);
    }
}
