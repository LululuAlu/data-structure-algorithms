package cn.lgwen.arithmetic;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2020/4/10
 * aven.wu
 * danxieai258@163.com
 */
public class ReversalString {

    public static String reversal(String string) {
        if (string == null || string.length() <= 1) {
            return string;
        }
        String trim = string.trim();
        char[] chars = trim.toCharArray();
        // 根据"" 将字符拆开
        List<String> words = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = chars.length-1; i >= 0 ; i --) {
            if (chars[i] == 32) {
                if(characters.size() > 0) {
                    Collections.reverse(characters);
                    char[] chars1 = new char[characters.size()];
                    int idx = 0;
                    for (Character character : characters) {
                        chars1[idx] = character;
                        idx++;
                    }
                    words.add(new String(chars1));
                    characters.clear();
                }
            } else {
                characters.add(chars[i]);
            }
            if (i == 0) {
                if(characters.size() > 0) {
                    Collections.reverse(characters);
                    char[] chars1 = new char[characters.size()];
                    int idx = 0;
                    for (Character character : characters) {
                        chars1[idx] = character;
                        idx++;
                    }
                    words.add(new String(chars1));
                    characters.clear();
                }
            }
        }
        return String.join(" ", words);
    }


    public static void main(String[] args) {
        String str1 = "the sky is blue";
        String str2 = "  hello world! ";
        String str3 = "a good   example";
        System.out.println(reversal(str1));
        System.out.println(reversal(str2));
        System.out.println(reversal(str3));
    }
}
