# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    nsum = 0
    def bstToGst(self, root: TreeNode) -> TreeNode:
        self.nodeSum(root)
        return root
    
    def nodeSum(self, node: TreeNode):
        if node is None:
            return
        
        global nsum
        
        self.nodeSum(node.right)
        self.nsum += node.val
        node.val = self.nsum
        self.nodeSum(node.left)
        