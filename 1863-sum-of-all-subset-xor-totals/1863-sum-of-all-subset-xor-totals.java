import java.util.Arrays;

class Solution {
    private int N, answer;
    private int[] nums;
    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        N = nums.length;
        
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
        String numberStr = Integer.toBinaryString(0);
        numberStr = "0".repeat(8 - numberStr.length()) + numberStr;
        String tmp, nextStr;
        for(int i = 0; i < count; i++) {
            nextStr = Integer.toBinaryString(selected[i]);
            nextStr = "0".repeat(8 - nextStr.length()) + nextStr;
            // System.out.println("numberStr:\t" + numberStr);
            // System.out.println("nextStr:\t" + nextStr);
            tmp = "";
            for(int j = 0; j < nextStr.length(); j++) {
                tmp += numberStr.charAt(j) == nextStr.charAt(j) ? "0":"1";
            }
            numberStr = tmp;
        }
        
        // System.out.printf("%s 값의 XOR = %d\n", Arrays.toString(nums), Integer.parseInt(numberStr, 2));
        return Integer.parseInt(numberStr, 2);
    }
}