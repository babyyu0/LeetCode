class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        sum_one = [(x, sum(y)) for x, y in enumerate(mat)]
        return [i for i, j in sorted(sum_one, key=lambda x:x[1])][:k]