class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        i = 1
        order = 1
        for x in range(time):
            if i == n:
                order = -1
            elif i == 1:
                order = 1
            i += order
        
        return i