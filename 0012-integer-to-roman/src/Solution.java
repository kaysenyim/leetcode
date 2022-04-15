/**
 * @author kaysenyim
 * @see <a href="https://leetcode-cn.com/problems/integer-to-roman/">...</a>
 */
public class Solution {
    public static String intToRoman(int num) {
        int[]    l1 = {1000,  900, 500,  400, 100,   90,  50,   40,  10,    9,   5,    4,   1};
        String[] l2 = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= l1[i]) {
                num -= l1[i];
                roman.append(l2[i]);
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        String r = intToRoman(1994);
        System.out.println(r);
    }
}
