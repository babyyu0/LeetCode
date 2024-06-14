class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int before = -1;
        int res = 0;
        for(auto& n : nums) {
            if(n <= before) {
                res += (before + 1 - n);
                n = before + 1;
            }
            before = n;
        }
        
        return res;
    }
};