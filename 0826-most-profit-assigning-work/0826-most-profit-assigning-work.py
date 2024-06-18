class Solution:
    work = list()
    
    def maxDif(self, w: int) -> int:
        left, right, mid = 0, len(work) - 1, 0
        
        while left + 1 < right:
            mid = int((left + right) / 2)
            if work[mid][0] == w:
                return mid
            elif work[mid][0] < w:
                left = mid
            elif work[mid][0] > w:
                right = mid
        
        if work[right][0] <= w: return right
        return left
    
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        global work
        work = dict()
        work[0] = 0
        
        for d, p in zip(difficulty, profit):
            work[d] = max(work[d], p) if d in work else p
        
        work = sorted(work.items())
        
        tmp = 0
        for i in range(len(work)):
            if tmp > work[i][1]:
                work[i] = (work[i][0], tmp)
            tmp = max(tmp, work[i][1])
        
        return sum(work[self.maxDif(w)][1] for w in worker)