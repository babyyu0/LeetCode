class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        left, costsum, answer = 0, 0, 0
        costs = []
        for i, (x, y) in enumerate(zip(s, t)):
            costs.append(abs(ord(x) - ord(y)))
            costsum += costs[i]
            
            if costsum <= maxCost:
                answer = max(answer, i - left + 1)
            else:
                costsum -= costs[left]
                left += 1
        return answer
        