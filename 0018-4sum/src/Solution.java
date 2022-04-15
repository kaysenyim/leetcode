import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kaysen
 * @see <a href="https://leetcode-cn.com/problems/4sum/">...</a>
 */
public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lli = new ArrayList<>();
        int len = nums.length;
        for (int a = 0; a < len - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < len - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                for (int c = b + 1; c < len -1; c++) {
                    if (c > b + 1 && nums[c] == nums[c - 1]) {
                        continue;
                    }
                    for (int d = c + 1; d < len; d++) {
                        if (d > c + 1 && nums[d] == nums[d - 1]) {
                            continue;
                        }
                        int sum = nums[a] + nums[b] + nums[c] + nums[d];
                        if (target == sum) {
                            lli.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        }
                    }
                }
            }
        }
        return lli;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> lli = fourSum(nums, target);
        System.out.println(lli);
    }
}
