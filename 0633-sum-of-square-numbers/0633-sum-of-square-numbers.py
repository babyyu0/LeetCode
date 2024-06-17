class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        i = 0
        
        b,d  = 0, 0
        while i ** 2 <= c:
            d = c - (i ** 2)
            b = math.sqrt(d)
            if b == int(b): return True
            i += 1
            
        return False