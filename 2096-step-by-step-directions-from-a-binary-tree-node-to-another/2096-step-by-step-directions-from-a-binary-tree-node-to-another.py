# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        #시작점 찾기
        queue = [[root, ""]]
        startDist, destDist = "", ""
        
        i, node = 0, None
        while len(queue) != 0:
            node, depth = queue[0][0], queue[0][1]
            del queue[0]
            if node.val == startValue:
                startDist = depth
            if node.val == destValue:
                destDist += depth
            
            if node.left != None:
                queue.append([node.left, depth + "L"])
            if node.right != None:
                queue.append([node.right, depth + "R"])
        
        i = 0
        while i < len(startDist) and i < len(destDist) and startDist[i] == destDist[i]:
            i += 1
        
        return "U" * len(startDist[i:]) + destDist[i:]