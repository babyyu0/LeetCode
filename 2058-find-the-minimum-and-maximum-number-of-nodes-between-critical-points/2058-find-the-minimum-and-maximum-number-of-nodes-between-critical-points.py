# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        before = head.val
        head = head.next
        minDist = 100000
        indexList = [-100000]
        
        i = 1
        while head.next != None:
            if head.val < min(before, head.next.val) or max(before, head.next.val) < head.val:
                minDist = min(minDist, i - indexList[-1])
                indexList.append(i)
            i += 1
            before = head.val
            head = head.next
        
        return [minDist, indexList[-1] - indexList[1]] if len(indexList) > 2 else [-1, -1];