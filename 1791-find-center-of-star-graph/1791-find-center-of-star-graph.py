class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        return [i for i in edges[0] if i in edges[1]][0]