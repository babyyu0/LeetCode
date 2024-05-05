import java.util.*;

class Solution {
    public int findMaxK(int[] nums) {
        int answer = -1;
        boolean[][] count = new boolean[1001][2];
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {  // 음수일 경우
                count[-nums[i]][0] = true;
                if(count[-nums[i]][1]) answer = Math.max(answer, -nums[i]);
            } else if (0 < nums[i]) {  // 양수일 경우
                count[nums[i]][1] = true;
                if(count[nums[i]][0]) answer = Math.max(answer, nums[i]);
            }
        }
        
        return answer;
    }
}