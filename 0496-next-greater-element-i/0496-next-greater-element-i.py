class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        return [[y for y in nums2[nums2.index(x):] if y > x][0] if max(nums2[nums2.index(x):]) > x else -1  for x in nums1]