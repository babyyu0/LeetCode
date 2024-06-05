class Solution {
    public List<String> commonChars(String[] words) {
        int[] alCnt = new int[27];
        int[] tmpCnt = new int[27];
        
        for(int i = 0; i < words[0].length(); i++) {
            alCnt[words[0].charAt(i) - 97]++;
        }
        
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                tmpCnt[word.charAt(i) - 97]++;
            }
            for(int i = 0; i < 27; i++) {
                alCnt[i] = Math.min(alCnt[i], tmpCnt[i]);
                tmpCnt[i] = 0;
            }
        }
        
        List<String> answer = new ArrayList<>();
        String c;
        for(int i = 0; i < 27; i++) {
            c = (char)(i + 97) + "";
            for(int j = 0; j < alCnt[i]; j++) {
                answer.add(c);
            }
        }
        
        return answer;
    }
}