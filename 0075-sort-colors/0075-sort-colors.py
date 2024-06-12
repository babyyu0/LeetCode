class Solution:
    def sortColors(self, nums: List[int]) -> None:
        flag = False
        for re in range(len(nums)):
            flag = False
            for i in range(len(nums) - 1):
                if nums[i] > nums[i + 1]:
                    nums[i], nums[i + 1] = nums[i + 1], nums[i]
                    flag = True
                
            if flag == False:
                break
        