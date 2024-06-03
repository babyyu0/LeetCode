class Solution(object):
    def appendCharacters(self, s, t):
        i = 0
        for c in s:
            if c == t[i]:
                i+=1
            if i >= len(t): return 0
        
        return len(t) - i
        