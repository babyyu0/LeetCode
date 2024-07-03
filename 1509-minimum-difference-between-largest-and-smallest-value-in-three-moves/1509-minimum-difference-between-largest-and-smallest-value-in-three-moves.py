class Solution:
    def minDifference(self, nums: List[int]) -> int:
        if len(nums) <= 4:
            return 0
        
        nums.sort()
        return min(abs(nums[0 + i] - nums[-1 - (3 - i)]) for i in range(4))