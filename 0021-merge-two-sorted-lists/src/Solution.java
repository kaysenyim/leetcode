import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * @author kaysen
 * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">...</a>
 */
public class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode merge;
        if (list1.val <= list2.val) {
            merge = list1;
            merge.next = mergeTwoLists(list1.next, list2);
        } else {
            merge = list2;
            merge.next = mergeTwoLists(list1, list2.next);
        }
        return merge;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merge = mergeTwoLists(list1, list2);
        System.out.println(merge);
    }
}
