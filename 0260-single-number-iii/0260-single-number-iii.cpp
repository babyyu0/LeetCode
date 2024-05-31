class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        vector<int> selected;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < nums.size(); i+=2) {
            if(i == nums.size() - 1 || nums[i] < nums[i + 1]) {
                selected.push_back(nums[i--]);
            }
            if(selected.size() == 2) break;
        }
        
        return selected;
    }
};