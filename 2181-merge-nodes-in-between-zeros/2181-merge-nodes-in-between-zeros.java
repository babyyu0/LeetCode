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
    public ListNode mergeNodes(ListNode head) {
        int n = 0;
        ListNode node = new ListNode(0);
        ListNode answer = node;
        
        head = head.next;
        while(head.next != null) {
            if(head.val == 0) {
                node.next = new ListNode(n);
                n = 0;
                node = node.next;
            } else {
                n += head.val;
            }
            
            head = head.next;
        }
        
        node.next = new ListNode(n);
        return answer.next;
    }
}