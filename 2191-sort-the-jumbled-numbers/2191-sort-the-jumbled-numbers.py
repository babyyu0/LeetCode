class Solution:
    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        tmp, count = 0, 0
        for i, x in enumerate(nums):
            tmp, count = 0, 0
            if x == 0:
                tmp = mapping[0]
            else:
                while x != 0:
                    tmp += mapping[x % 10] * 10 ** count
                    x //= 10
                    count += 1
            nums[i] = [nums[i], tmp]
        
        return [x for x, _ in sorted(nums, key=lambda x: (x[1]))]