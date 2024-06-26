# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    nnums = list()
    visited = list()
    
    def balanced(self, left: int, right: int) -> TreeNode:
        global visited
        if left + 1 == right:
            return TreeNode(val=self.nnums[right], left=TreeNode(val=self.nnums[left]))
        elif left == right:
            return TreeNode(val=self.nnums[right])
        
        mid = (left + right) // 2
        self.visited[mid] = True
        return TreeNode(val=self.nnums[mid], left=self.balanced(left, mid - 1), right=self.balanced(mid + 1, right))
    
    def balanceBST(self, root: TreeNode) -> TreeNode:
        global nnums
        global visited
        queue = [root]
        
        self.nnums = list()
        self.visited = list()
        #노드 Value 뽑기
        node = None
        while len(queue) != 0:
            node = queue[0]
            del queue[0]
            self.nnums.append(node.val)
            self.visited.append(False)
            
            if node.left is not None:
                queue.append(node.left)
            if node.right is not None:
                queue.append(node.right)
                
        self.nnums.sort()
        # print(self.nnums)
        return self.balanced(0, len(self.nnums) - 1)