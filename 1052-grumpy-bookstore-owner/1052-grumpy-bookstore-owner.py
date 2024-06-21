class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        N = len(customers)
        oriCount = [0] * N
        teqCount = [0] * N
        accumulated = list()
        tmp = 0
        for i in customers:
            tmp += i
            accumulated.append(tmp)
        
        oriCount[0] = customers[0] * (grumpy[0] ^ 1)
        teqCount[minutes - 1] = sum(customers[:minutes])
    
        
        for i in range(1, N):
            oriCount[i] = oriCount[i - 1] + customers[i] * (grumpy[i] ^ 1)
            teqCount[i] = max(teqCount[i], teqCount[i - 1] + customers[i] * (grumpy[i] ^ 1))
            
            if i + minutes <= N:
                teqCount[i + minutes - 1] = max(
                    teqCount[i + minutes - 1],
                    oriCount[i - 1] + accumulated[i + minutes - 1] - accumulated[i - 1]
                )
        
        
        return teqCount[N-1]