class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int N = nums.length;
        int[] mods = new int[k];
        mods[0] = 1;
        int answer = 0;
        
        int mod = 0;
        for(int i = 0; i < N; i++) {
            mod = (mod + nums[i] % k + k) % k;
            answer += mods[mod];
            mods[mod]++;
        }
        
        return answer;
    }
}