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
            while(!stack.isEmpty() && stack.peek() < head.val) {
                stack.pop();
            }
            stack.push(head.val);
            head = head.next;
        }
        
        ListNode node = new ListNode(stack.pop(), null);
        while(!stack.isEmpty()) {
            node = new ListNode(stack.pop(), node);
        }
        
        return node;
    }
    private void print(ListNode node) {
        while(node.next.next != null) {
            System.out.printf("%d -> ", node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }
}