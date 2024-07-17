# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        queue = deque([root])
        def dfs(node: Optional[TreeNode]) -> TreeNode:
            if node == None: # 노드가 존재하지 않을 경우
                return None
            elif node.val in to_delete: #삭제할 노드의 경우
                if node.left != None:
                    queue.append(node.left)
                if node.right != None:
                    queue.append(node.right)
                
                return None
                    
            madeNode = TreeNode(node.val)
            madeNode.left = dfs(node.left)
            madeNode.right = dfs(node.right)
            
            return madeNode
        
         
        answer = []
        while len(queue) != 0:
            root = dfs(queue.popleft())
            if root != None:
                answer.append(root)
        
        return answer
        