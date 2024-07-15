# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        tdict = {}
        parentList, childList = list(), list()
        for parent, child, isLeft in descriptions:
            parentList.append(parent)
            childList.append(child)
            
            if parent not in tdict:
                tdict[parent] = TreeNode(parent)
            if child not in tdict:
                tdict[child] = TreeNode(child)
            
            if isLeft > 0:
                tdict[parent].left = tdict[child]
            else:
                tdict[parent].right = tdict[child]
                
                
        return tdict[[x for x in parentList if x not in childList][0]]