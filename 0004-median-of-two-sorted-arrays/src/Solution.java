/**
 * @author kaysenyim
 * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">...</a>
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLen = m + n;
        if (totalLen % 2 == 0) {
            double median1 = findKthElement(nums1, 0, nums2, 0, totalLen / 2);
            double median2 = findKthElement(nums1, 0, nums2, 0, totalLen / 2 + 1);
            return (median1 + median2) / 2;
        } else {
            return findKthElement(nums1, 0, nums2, 0, totalLen / 2 + 1);
        }
    }

    /**
     * 寻找第k小数
     * @param nums1 正序数组1
     * @param idx1 nums1的起始下标
     * @param nums2 正序数组2
     * @param idx2 nums2的起始下标
     * @param k
     * @return nums1与nums2合并后新数组中第k个元素
     */
    public double findKthElement(int[] nums1, int idx1, int[] nums2, int idx2, int k) {
        // 递归收敛
        if (idx1 >= nums1.length) {
            return nums2[idx2 + k - 1];
        }
        if (idx2 >= nums2.length) {
            return nums1[idx1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[idx1], nums2[idx2]);
        }
        int half = k / 2;
        int newIdx1 = Math.min(idx1 + half, nums1.length) - 1;
        int newIdx2 = Math.min(idx2 + half, nums2.length) - 1;
        if (nums1[newIdx1] <= nums2[newIdx2]) {
            return findKthElement(nums1, newIdx1 + 1, nums2, idx2, k - (newIdx1 - idx1 + 1));
        } else {
            return findKthElement(nums1, idx1, nums2, newIdx2 + 1, k - (newIdx2 - idx2 + 1));
        }
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double med = o.findMedianSortedArrays(nums1, nums2);
        System.out.println(med);
    }
}
