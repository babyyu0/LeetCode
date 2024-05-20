import java.util.Arrays;

class Solution {
    private int N, answer;
    private int[] nums;
    private String[][] saved;
    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        N = nums.length;
        saved = new String[30][30];
        
        combination(0, 0, new int[N]);
        answer += calXOR(nums, N);
        
        return answer;
    }
    
    private void combination(int start, int count, int[] selected) {
        if(count == nums.length) return;
        answer += calXOR(selected, count);
        for(int i = start; i < nums.length; i++) {
            selected[count] = nums[i];
            combination(i + 1, count + 1, selected);
        }
    }
    
    private int calXOR(int[] selected, int count) {
        int number = 0;
        for(int i = 0; i < count; i++) {
            number = number ^ selected[i];
        }
        
        return number;
    }
}