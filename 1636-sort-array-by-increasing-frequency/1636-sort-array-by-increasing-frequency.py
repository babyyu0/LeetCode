class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        def comparator(a, b):
            x, y = nums.count(a), nums.count(b)
            if x == y:
                return 1 if a < b else -1
            else:
                return 1 if x > y else -1
        return sorted(sorted(nums, reverse=True), key=cmp_to_key(comparator))