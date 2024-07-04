# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        node = ListNode(0)
        answer = node
        n = 0
        head = head.next
        
        while head.next != None:
            if head.val == 0:
                node.next = ListNode(n)
                n = 0
                node = node.next
            else:
                n += head.val
                
            head = head.next
        
        node.next = ListNode(n)
        
        return answer.next