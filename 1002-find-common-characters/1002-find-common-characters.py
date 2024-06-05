class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        alCnt = [words[0].count(chr(i + 97)) for i in range(27)]
        
        for word in words:
            for n in range(27):
                alCnt[n] = min(alCnt[n], word.count(chr(n + 97)))
                
        return [chr(i + 97) for i, cnt in enumerate(alCnt) for j in range(cnt) if cnt > 0]
        
        
        