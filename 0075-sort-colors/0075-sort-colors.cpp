class Solution {
public:
    void sortColors(vector<int>& nums) {
        int N = nums.size();
        int tmp;
        bool flag;
        for(int re = 0; re < N; re++) {
            flag = false;
            for(int i = 0; i < N - 1; i++) {
                if(nums[i] > nums[i + 1]) {
                    flag = true;
                    
                    tmp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = tmp;
                }
            }
            
            if(!flag) break;
        }
    }
};