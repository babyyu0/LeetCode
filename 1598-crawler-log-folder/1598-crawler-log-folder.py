class Solution:
    def minOperations(self, logs: List[str]) -> int:
        toMain = 0
        for log in logs:
            if log == "../":
                toMain = max(0, toMain - 1)
            elif log != "./":
                toMain += 1
                
        return toMain;