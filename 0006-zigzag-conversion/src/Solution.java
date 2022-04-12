/**
 * @author kaysenyim
 * @see <a href="https://leetcode-cn.com/problems/zigzag-conversion/">...</a>
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] zigzag = new StringBuilder[numRows];
        for (int i = 0; i < zigzag.length; i++) {
            zigzag[i] = new StringBuilder();
        }
        char[] chars = s.toCharArray();
        for (int i = 0, row = 0; i < chars.length; i++) {
            zigzag[row].append(chars[i]);
            if ((i / (numRows - 1)) % 2 == 0) {
                row++;
            } else {
                row--;
            }
        }
        StringBuilder rest = new StringBuilder();
        for (StringBuilder stringBuilder : zigzag) {
            rest.append(stringBuilder.toString());
        }
        return rest.toString();
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        String rest = o.convert("PAYPALISHIRING", 1);
        System.out.println(rest);
    }
}
