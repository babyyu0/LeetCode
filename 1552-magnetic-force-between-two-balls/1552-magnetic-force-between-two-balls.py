class Solution:
    def canDist(self, position: List[int], m:int, d: int) -> bool:
        cnt,before = 1, position[0]
        for p in position[1:]:
            if p - before < d:
                continue
            
            cnt+=1
            before = p
            if m <= cnt:
                break
        return m <= cnt
    
    def maxDistance(self, position: List[int], m: int) -> int:
        dist, count, before = 1, 0, 0
        visited = set()
        position.sort()
        if m == 2:
            return position[-1] - position[0]
        
        left,right,mid = 0, position[-1] - position[0], 0
        res = 0
        
        while left + 1 < right:
            mid = int((left + right) / 2)
            if self.canDist(position, m, mid):
                res = max(res, mid)
                left = mid
            else:
                right = mid
            
        return res
        