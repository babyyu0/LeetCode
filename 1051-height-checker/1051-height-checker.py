class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        return len([i for i, j in zip(heights, sorted(heights)) if i != j])
        