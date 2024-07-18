# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import queue

class Solution:
    def countPairs(self, root: TreeNode, distance: int) -> int:
        leafs = []
        
        q = queue.Queue()
        q.put([root, ""])
        
        node, dist = None, None
        while q.empty() == False:
            node, dist = q.get()
            if node.left == None and node.right == None:
                leafs.append(dist)
            if node.left != None:
                q.put([node.left, dist + "L"])
            if node.right != None:
                q.put([node.right, dist + "R"])
        
        answer = 0
        for i, leaf1 in enumerate(leafs):
            for leaf2 in leafs[i + 1:]:
                k = 0
                while leaf1[k] == leaf2[k]:
                    k += 1
                
                if len(leaf1) + len(leaf2) - k * 2 <= distance:
                    answer += 1
        
        
        return answer