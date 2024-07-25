class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        if len(nums) == 0 or max(nums) == min(nums):
            return nums
        mid = (max(nums) + min(nums)) / 2
        smallers, biggers = [], []

        for num in nums:
            if num < mid:
                smallers.append(num)
            else:
                biggers.append(num)

        return self.sortArray(smallers) + self.sortArray(biggers)