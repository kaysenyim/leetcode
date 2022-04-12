/**
 * @author kaysenyim
 * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/">...</a>
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int val = l1.val + l2.val;
        ListNode next = addTwoNumbers(l1.next, l2.next);
        if (val >= 10) {
            val -= 10;
            next = addTwoNumbers(next, new ListNode(1));
        }
        return new ListNode(val, next);
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.fromArray(new int[]{2,4,3});
        ListNode l2 = ListNode.fromArray(new int[]{5,6,4});
        Solution o = new Solution();
        ListNode l = o.addTwoNumbers(l1, l2);
        System.out.println(l);
    }
}
