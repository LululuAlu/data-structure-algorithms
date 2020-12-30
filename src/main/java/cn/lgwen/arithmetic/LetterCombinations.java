package cn.lgwen.arithmetic;

import java.util.*;

/**
 * @Author aven.wu
 * @Date 2020/12/29
 * 17. 电话号码的字母组合
 */
public class LetterCombinations {

    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("23");
        Queue<String> queue = new ArrayDeque<>();
        queue.size();

    }

    Map<Character, String> dict = new HashMap<>();
    {
        dict.put('2', "abc");
        dict.put('3', "edf");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
    }
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        recursion(0, "", digits);
        res.sort(String::compareTo);
        return res;
    }

    public void recursion(int i, String sub, String digits) {
        if(i == digits.length()) {
            res.add(sub);
            return;
        }
        String chars = dict.get(digits.charAt(i));
        for (int j = 0; j < chars.length(); j++) {
            recursion(i+1, sub + chars.charAt(j), digits);
        }
    }
}
