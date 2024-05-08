import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        
        int max = stack.pop();
        ListNode node = new ListNode(max, null);
        int n;
        while(!stack.isEmpty()) {
            n = stack.pop();
            if(n >= max) {
                node = new ListNode(n, node);
                max = n;
            }
        }
        
        return node;
    }
}