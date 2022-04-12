/**
 * @author kaysenyim
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/">...</a>
 */
public class Solution {
    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int a = maxArea(height);
        System.out.println(a);
    }
}
