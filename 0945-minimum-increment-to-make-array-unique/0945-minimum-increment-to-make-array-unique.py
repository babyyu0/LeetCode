class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        res = 0
        before = -1
        nums.sort()
        for n in nums:
            if before >= n:
                res += (before + 1) - n
                n = before + 1
            before = n
        
        return res