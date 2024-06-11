class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        answer1, answer2 = [], []
        
        for i in arr1:
            if i in arr2: answer1.append(i)
            else: answer2.append(i)
                
        answer1 = sorted(answer1, key=lambda x : arr2.index(x))
        answer2 = sorted(answer2)
        
        return answer1 + answer2