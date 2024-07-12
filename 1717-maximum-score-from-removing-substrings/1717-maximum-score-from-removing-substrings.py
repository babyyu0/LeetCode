class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        point, i = 0, 0
        stack1, stack2 = list(), list()
        
        word1, word2 = 'a', 'b'
        if x < y:
            word1, word2 = word2, word1
            x, y = y, x
        
        for c in s:
            if c == word2 and len(stack1) != 0 and stack1[-1] == word1:
                stack1.pop()
                point += x
            else:
                stack1.append(c)
        
        for c in stack1:
            if c == word1 and len(stack2) != 0 and stack2[-1] == word2:
                stack2.pop()
                point += y
            else:
                stack2.append(c)
        
        return point