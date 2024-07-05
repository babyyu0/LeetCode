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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> indexList = new ArrayList<>();
        indexList.add(-1000000);
        int min = 1000000;
        
        int before = head.val, i = 1, dist;
        head = head.next;
        
        while(head.next != null) {
            if (before < head.val && head.next.val < head.val
               || head.val < before && head.val < head.next.val) {
                dist = i - indexList.get(indexList.size() - 1);
                min = Math.min(dist, min);
                
                indexList.add(i);
            }
            before = head.val;
            head = head.next;
            i++;
        }
        
        // System.out.printf("Index List: %s\n", indexList);
        
        if(indexList.size() <= 2) {
            return new int[]{-1, -1};
        }
        
        return new int[]{min, indexList.get(indexList.size() - 1) - indexList.get(1)};
    }
}