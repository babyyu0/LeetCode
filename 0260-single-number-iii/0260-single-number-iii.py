class Solution(object):
    def singleNumber(self, nums):
        return [n for n in nums if nums.count(n) == 1]
        