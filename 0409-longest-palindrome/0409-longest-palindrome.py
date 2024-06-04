class Solution:
    def longestPalindrome(self, s: str) -> int:
        answer = [s.count(chr(n)) for n in range(ord('a'), ord('z') + 1)]
        answer += [s.count(chr(n)) for n in range(ord('A'), ord('Z') + 1)]
        answer = sum(n if n % 2 == 0 else n - 1 for n in answer)
        return answer + 1 if len(s) > answer else answer