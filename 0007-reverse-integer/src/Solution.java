/**
 * @author kaysenyim
 * @see <a href="https://leetcode-cn.com/problems/reverse-integer/">...</a>
 */
public class Solution {
    public int reverse(int x) {
        int n = 0;
        while (x != 0) {
            // Integer.MAX_VALUE < n * 10 + x % 10
            // Integer.MIN_VALUE > n * 10 + x % 10
            // x是int（2147483647 ～ -2147483648），x取边界值时，新的个位数为2，所以 x % 10 不会导致int越界
            int digit = x % 10;
            if (Integer.MAX_VALUE / 10 < n || Integer.MIN_VALUE / 10 > n) {
                return 0;
            }
            n = n * 10 + digit;
            x /= 10;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        int n = o.reverse(1534236469);
        System.out.println(n);
    }
}
