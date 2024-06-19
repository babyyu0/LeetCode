class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        bouquets = list()
        res = -1
        dayList = list(set(bloomDay))
        dayList.sort(reverse=True)
        
        count, bcnt = 0, 0
        for day in dayList:
            count, bcnt = 0, 0
            for b in bloomDay:
                if b <= day:
                    count+=1
                    
                    if count == k:
                        bcnt += 1
                        count = 0
                        
                        if bcnt == m:
                            break
                else:
                    count = 0
            if bcnt == m:
                res = day
            else:
                break
        
        return res
            