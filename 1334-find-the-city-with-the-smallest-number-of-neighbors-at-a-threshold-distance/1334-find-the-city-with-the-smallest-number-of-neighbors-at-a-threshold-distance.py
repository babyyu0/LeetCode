class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        dists = [[10001 if i != j else 0 for i in range(n)] for j in range(n)]
        
        for fr, t, w in edges:
            dists[fr][t] = min(dists[fr][t], w)
            dists[t][fr] = min(dists[t][fr], w)
        
        flag = False
        for _ in range(n):
            for r in range(n):
                for c in range(n):
                    if r == c: #원점일 경우 넘어가기
                        continue
                    for tr in range(n):
                        if dists[r][c] > dists[r][tr] + dists[tr][c]:
                            flag = True
                            dists[r][c] = dists[r][tr] + dists[tr][c]
            if not flag: #더이상 바뀌는 값이 없을 경우
                break
            flag = False
            
        answer_list = [sum(d <= distanceThreshold for d in dist) for dist in dists]
        return max([i for i, val in enumerate(answer_list) if val == min(answer_list)])