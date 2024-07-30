class Solution:
    def minimumDeletions(self, s: str) -> int:
        answer = len(s)
        del_a, cnt = [0] * len(s), 0
        print(del_a)
        for i in range(len(s) - 1, -1, -1):
            del_a[i] = cnt
            cnt += int(s[i] == 'a')
            
        cnt = 0
        for i in range(len(s)):
            answer = min(del_a[i] + cnt, answer)
            cnt += int(s[i] == 'b')
        return answer
            