class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        answer = []
        count, min_idx = 0, 0
        
        for i, m in enumerate(matrix):
            min_idx, count = 0, 0
            for j in range(1, len(m)):
                if m[j] < m[min_idx]:
                    min_idx = j
            # print("행의 최솟값:", m[min_idx])
            
            for m2 in matrix:
                # print(m2[min_idx], "값과 비교", end="\t")
                if m2[min_idx] > m[min_idx]:
                    break
                count += 1
            
            if count == len(matrix):
                answer.append(m[min_idx])
        return answer