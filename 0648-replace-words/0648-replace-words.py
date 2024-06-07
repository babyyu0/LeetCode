class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        answer = list()
        dictionary.sort()
        
        for s in sentence.split():
            for i in dictionary:
                if i in s[0:len(i)]:
                    s = i
                    break
            answer.append(s)
        return ' '.join(answer)
        