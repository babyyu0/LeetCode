class Solution {
    public int specialArray(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        
        int count;
        for(int i = nums[N - 1]; i >= 0; i--) {
            count = 0;
            for(int j = 0; j < N; j++) {
                if(i <= nums[j]) {
                    if(++count > i) break;
                }
            }
            if(count == i) return i;
        }
        
        return -1;
    }
}