class Solution:
    index = 0
    
    def reverseParentheses(self, s: str) -> str:
        global index
        answer = ""
        while self.index < len(s) and s[self.index] != ')':
            if s[self.index] == '(':
                self.index += 1
                answer += self.reverseParentheses(s)
            else:
                answer += s[self.index]
            self.index += 1
                
        # print("answer:", answer)
        if len(s) == self.index:
            return answer
        return answer[::-1]