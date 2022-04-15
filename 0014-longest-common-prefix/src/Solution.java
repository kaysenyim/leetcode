/**
 * @author kaysen
 * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix/">...</a>
 */
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        out:
        for (int i = 0; ; i++) {
            Character c = null;
            for (String str : strs) {
                if (i == str.length()) {
                    break out;
                }
                if (c == null) {
                    c = str.charAt(i);
                } else if (c != str.charAt(i)) {
                    c = null;
                    break out;
                }
            }
            if (c != null) {
                prefix.append(c);
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String prefix = longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
