import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode fromArray(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode[] nodes = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new ListNode(nums[i]);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }

    public int[] toArray() {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(this.val);
        ListNode next = this.next;
        while(next != null) {
            tmp.add(next.val);
            next = next.next;
        }
        return tmp.stream().mapToInt(Integer::valueOf).toArray();
    }

    @Override
    public String toString() {
        int[] nums = this.toArray();
        return Arrays.toString(nums);
    }
}
