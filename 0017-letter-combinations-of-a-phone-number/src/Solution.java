import java.util.*;

/**
 * @author kaysen
 * @see <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/">...</a>
 */
public class Solution {
    public static List<String> letterCombinations(String digits) {
        Map<Character, String> lettersMap = new HashMap<>(8);
        lettersMap.put('2', "abc");
        lettersMap.put('3', "def");
        lettersMap.put('4', "ghi");
        lettersMap.put('5', "jkl");
        lettersMap.put('6', "mno");
        lettersMap.put('7', "pqrs");
        lettersMap.put('8', "tuv");
        lettersMap.put('9', "wxyz");
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, new StringBuffer(), digits, 0, lettersMap);
        return combinations;
    }

    public static void backtrack(List<String> combinations, StringBuffer combination, String digits, int index, Map<Character, String> lettersMap) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = lettersMap.get(digit);
            for (char letter : letters.toCharArray()) {
                // 先不考虑新字符产生组合与原来的组合长度不一致，先生成所有组合后面再删除重复的字符
                combination.append(letter);
                backtrack(combinations, combination, digits, index + 1, lettersMap);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        List<String> combinations = letterCombinations("23");
        System.out.println(combinations);
    }
}
