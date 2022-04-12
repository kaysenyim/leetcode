/**
 * @author kaysenyim
 * @see <a href="https://leetcode-cn.com/problems/palindrome-number/">...</a>
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int i = x / 10;
        int num = x % 10;
        while (i != 0) {
            num = num * 10 + i % 10;
            i = i / 10;
        }
        return num == x;
    }

    public static void main(String[] args) {
        boolean b = isPalindrome(12321);
        System.out.println(b);
    }
}
