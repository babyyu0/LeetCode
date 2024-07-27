# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        queue = [(root, str(root.val))]
        answer = list()
        
        i, node = 0, None
        while i < len(queue):
            node, str_node = queue[i]
            if node.left:
                queue.append((node.left, str_node + "->" + str(node.left.val)))
            if node.right:
                queue.append((node.right, "" + str_node + "->" + str(node.right.val)))
            if node.left == None and node.right == None:
                answer.append(str_node)
            i += 1
        
        return answer
            