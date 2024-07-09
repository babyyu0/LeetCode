class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        waitingList = list()
        curTime = 0
        
        for arrival, time in customers:
            waitingList.append(max(0, curTime - arrival) + time)
            # print("waiting:", max(0, curTime - arrival), "+", time)
            curTime = max(curTime, arrival) + time
        
        return sum(waitingList) / len(waitingList)
            
            
            