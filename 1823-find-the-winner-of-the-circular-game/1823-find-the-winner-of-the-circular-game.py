class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        queue = list()
        for i in range(1, n + 1):
            queue.append(i)
        
        while len(queue) > 1:                
            # print(queue)
            for i in range(k - 1):
                queue.append(queue[0])
                del queue[0]
                
            del queue[0]
            
        return queue[0]