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

import java.math.*;
import java.util.*;
class Solution {
    private StringBuilder multiply;
    public ListNode doubleIt(ListNode head) {
        multiply = new StringBuilder();
        while(head.next != null) {
            multiply.append(head.val);
            head = head.next;
        }
        multiply.append(head.val);
        multiply = new StringBuilder(new BigInteger(multiply.toString()).multiply(new BigInteger("2")).toString());
        return toNode(0);
    }
    private ListNode toNode(int count) {
        return new ListNode(
            multiply.charAt(count) - '0',
            (count == multiply.length() - 1) ? null : toNode(count + 1));
    }
}