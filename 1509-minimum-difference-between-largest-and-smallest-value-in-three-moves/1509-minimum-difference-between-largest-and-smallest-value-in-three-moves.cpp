class Solution {
public:
    int minDifference(vector<int>& nums) {
        if(nums.size() <= 4) return 0;
        
        int N = nums.size();
        sort(nums.begin(), nums.end());
        int answer = nums[N - 1] - nums[0];
        
        for(int i = 0; i <= 3; i++) {
            answer = min(abs(nums[0 + i] - nums[N - 1 - (3 - i)]), answer);
        }
        
        return answer;
    }
};