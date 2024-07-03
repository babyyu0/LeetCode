class Solution {
public:
    int minDifference(vector<int>& nums) {
        if(nums.size() <= 4) return 0;
        
        int N = nums.size();
        sort(nums.begin(), nums.end());
        long answer = nums[N - 1] - nums[0];
        
        for(int i = 0; i <= 3; i++) {
            if(answer > abs(nums[0 + i] - nums[N - 1 - (3 - i)])) {
                answer = abs(nums[0 + i] - nums[N - 1 - (3 - i)]);
            }
        }
        
        return answer;
    }
};