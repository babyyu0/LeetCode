import java.util.*;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int count = -1;
        long answer = 0;
        
        int i = happiness.length - 1;
        while(k > ++count) {
            answer += Math.max(happiness[i--] - count, 0);
        }
        
        return answer;
    }
}