class Solution:
    def magicalString(self, n: int) -> int:
        magical = "122"
        
        mnum = ["1", "2"]
        i, j = 0, 2
        while len(magical) < n:
            for ind in range(int(magical[j])):
                magical += mnum[i]
            
            i = (i + 1) % 2
            j += 1
        
        return magical[:n].count("1");
            