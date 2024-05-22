
class Solution:
    answer: List[List[str]]
    def findPalindrome(self, s, selected):
        if not s:
            # print(selected)
            self.answer.append(selected.copy())
            return
        for i in range(len(s)):
            subS = s[0:i + 1]
            # print("subS:", subS)
            sub1 = subS[:int(i / 2) + 1]
            sub2 = subS[int(i / 2) if i % 2 == 0 else int(i / 2) + 1:][::-1]
            
            if(len(subS) == 1 or sub1 == sub2):
                selected.append(subS)
                self.findPalindrome(s[i + 1:], selected)
                selected.pop()
    
    def partition(self, s: str) -> List[List[str]]:
        self.answer = []
        self.findPalindrome(s, [])
        return self.answer
        
        