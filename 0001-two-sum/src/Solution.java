import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kaysenyim
 * @see <a href="https://leetcode-cn.com/problems/two-sum/">...</a>
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        // 已经遍历过的数组元素用这个Map记录，数组最后一个元素不在需要被记录，所需的最大长度为nums.length - 1
        Map<Integer, Integer> map = new HashMap<>(len - 1);
        map.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            // n + nums[i] == target
            int n = target - nums[i];
            // 在已遍历的数组元素中寻找能与nums[i]求和之后得到target的元素
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Solution o = new Solution();
        int[] rest = o.twoSum(nums, target);
        System.out.println(Arrays.toString(rest));
    }
}
