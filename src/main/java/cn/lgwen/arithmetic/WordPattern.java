package cn.lgwen.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author aven.wu
 * @Date 2020/12/16
 */
public class WordPattern {

    public static void main(String[] args) {
       boolean a =  new WordPattern().wordPattern("abba", "dog dog dog dog");
    }
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (charMap.containsKey(c)) {
                // 如果当字符已经被映射过了
                // 取出结果和当前的word 进行比较，不一致直接返回false
                if (!charMap.get(c).equals(words[i])) return false;
            } else {
                // 如果当前字符没有被映射
                // 判断当前单词是否被映射过，如果被映射过，则发现有 不一样的字符映射了同样的单词
                if (wordMap.containsKey(words[i])) return false;
                // 添加映射关系
                charMap.put(c, words[i]);
                wordMap.put(words[i], c);
            }
        }
        return true;
    }
}
