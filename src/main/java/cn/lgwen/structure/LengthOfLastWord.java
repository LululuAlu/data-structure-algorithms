package cn.lgwen.structure;

/**
 * 2020/5/15
 * aven.wu
 * danxieai258@163.com
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        int i = new LengthOfLastWord().lengthOfLastWord(" a");
        System.out.println(i);
    }

    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean notEmpty = false;
        for(int i = s.length() -1 ; i >= 0; i--) {
            if (s.charAt(i) != 32) {
                len++;
                notEmpty = true;
                continue;
            }
            if (s.charAt(i) == 32 && notEmpty) {
                return len;
            }

        }
        return len;
    }
}
