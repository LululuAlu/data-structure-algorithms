package cn.lgwen.structure;

/**
 * 2020/5/18
 * aven.wu
 * danxieai258@163.com
 */
public class PlusBinary {

    public static void main(String[] args) {
       String res = plus("1", "11");
        System.out.println(res);
    }

    public static String plus(String a, String b) {
        int mLen = Math.max(a.length(), b.length());
        // 反转字符串
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int carryBit = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < mLen; i++) {
            char ca = i < a.length() ? a.charAt(i) : '0';
            char cb = i < b.length() ? b.charAt(i) : '0';
            int tmp = ca + cb + carryBit;
            if (ca + cb + carryBit >= 98) {
                // 表示需要进位
                carryBit = 1;
            } else {
                carryBit = 0;
            }
            res.append(tmp % 2);
        }
        if (carryBit > 0) {
            res.append('1');
        }
        return res.reverse().toString();


    }
}
