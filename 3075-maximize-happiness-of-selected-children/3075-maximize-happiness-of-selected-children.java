import java.util.*;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int zero = 0;
        long answer = 0;
        
        for(int i = happiness.length - 1; i >= 0 && zero != k; i--) {
            answer += Math.max(happiness[i] - zero, 0);
            zero++;
        }
        
        return answer;
    }
}