/**
 * @author kaysenyim
 * @see <a href="https://leetcode-cn.com/problems/roman-to-integer/">...</a>
 */
public class Solution {
    public static int romanToInt(String s) {
        int n = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && toInt(chars[i]) < toInt(chars[i + 1])) {
                n -= toInt(chars[i]);
            } else {
                n += toInt(chars[i]);
            }
        }
        return n;
    }

    public static int toInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        int n = romanToInt("MCMXCIV");
        System.out.println(n);
        System.out.println((int)'X');
    }
}
