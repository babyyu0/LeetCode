class Solution {
    public int heightChecker(int[] heights) {
        int N = heights.length;
        int[] ori = new int[N];
        for(int i = 0; i < N; i++) {
            ori[i] = heights[i];
        } 
        
        Arrays.sort(heights);
        
        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(ori[i] != heights[i]) answer++;
        }
        
        return answer;
    }
}