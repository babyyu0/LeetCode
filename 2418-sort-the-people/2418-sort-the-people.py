class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        name_height = []
        for n, h in zip(names, heights):
            name_height.append((n, h))
        
        return [i for i, j in sorted(name_height, key=lambda x:x[1], reverse=True)]