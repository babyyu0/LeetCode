class Solution:
    def reverseString(self, s: List[str]) -> None:
        tmp = ''
        for i in range(int(len(s) / 2)):
            tmp = s[i]
            s[i] = s[-i - 1]
            s[-i - 1] = tmp