class Solution:
    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        tmp, mapping_num, count = 0, 0, 0
        for i, x in enumerate(nums):
            tmp, mapping_num, count = x, 0, 0
            while tmp != 0:
                mapping_num += mapping[tmp % 10] * 10 ** count
                tmp //= 10
                count += 1
            nums[i] = [x, mapping_num if x != 0 else mapping[0]]
        
        return [x for x, _ in sorted(nums, key=lambda x: (x[1]))]