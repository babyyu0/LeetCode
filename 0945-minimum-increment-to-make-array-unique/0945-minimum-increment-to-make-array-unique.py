class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        deq = deque()
        visited = set()
        nums.sort(reverse=True)
        res = 0
        
        tmp = nums[0] + 1 #이전 숫자를 담을 변수
        maxNum = nums[0] + 1 #범위 이상의 방문하지 않은 숫자를 담을 변수
        
        N = len(nums)
        for index, n in enumerate(nums):
            for i in range(tmp - 1, n, -1):
                deq.append(i)
                if len(deq) > N - index:
                    deq.popleft()

                    
            
            if len(deq) == 0:
                deq.append(maxNum)
                maxNum += 1
            #print("현재 Deque:", deq)
            
            if n in visited: #이미 방문된 숫자일 경우
                tmp = deq.pop()
                res += (tmp - n) # 현재 숫자를 방문하지 않은 큰 숫자로 바꿈
                visited.add(tmp)
            else:
                visited.add(n)
            
            tmp = n #현재 n이 다음 반복의 이전 숫자가 됨
        
        return res