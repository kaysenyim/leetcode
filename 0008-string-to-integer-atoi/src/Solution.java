/**
 * @author kaysenyim
 * @see <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">...</a>
 */
public class Solution {
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int num = 0;
        boolean isNeg = false;
        int begin = 0;
        // 读入字符串并丢弃无用的前导空格
        while(begin < s.length() && s.charAt(begin) == ' ') {
            begin++;
        }
        if (s.length() == begin) {
            return 0;
        }
        if (s.charAt(begin) == '-') {
            isNeg = true;
            begin++;
        } else if (s.charAt(begin) == '+') {
            // isNeg = false;
            begin++;
        }
        for (int i = begin; i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9'; i++) {
            int before = num;
            num = num * 10 + Character.getNumericValue(s.charAt(i));
            if (before != num / 10) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return isNeg ? -num : num;
    }

    public static void main(String[] args) {
        int n = myAtoi(" ");
        System.out.println(n);
    }
}
