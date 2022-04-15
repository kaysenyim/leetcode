import com.sun.xml.internal.ws.api.model.CheckedException;

import java.util.LinkedList;

/**
 * @author kaysen
 * @see <a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">...</a>
 */
public class Solution {
    static int i = 0;

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        // 递归到链尾时开始收敛，i视为从后往前的下标。
        if (n == ++i) {
            return head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        ListNode node = removeNthFromEnd(head, 2);
        System.out.println(node);
    }
}
