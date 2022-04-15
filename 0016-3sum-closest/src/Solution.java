import java.util.Arrays;

/**
 * @author kaysen
 * @see <a href="https://leetcode-cn.com/problems/3sum-closest/">...</a>
 */
public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 0, minDif = Integer.MAX_VALUE, len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int dif = sum - target;
                if (Math.abs(dif) < minDif) {
                    minDif = Math.abs(dif);
                    closestSum = sum;
                }
                if (dif < 0) {
                    left++;
                } else if (dif > 0) {
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        int target = 1;
        int closest = threeSumClosest(nums, target);
        System.out.println(closest);
    }
}
