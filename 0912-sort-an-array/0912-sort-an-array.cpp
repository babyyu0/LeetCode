class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        if(nums.empty() || *min_element(nums.begin(), nums.end()) == *max_element(nums.begin(), nums.end())) {
            return nums;
        }
        vector<int> smallers, biggers;
        float mid = (*min_element(nums.begin(), nums.end()) + *max_element(nums.begin(), nums.end())) / 2.0;
        
        for(auto& num : nums) {
            if(num < mid) {
                smallers.push_back(num);
            } else {
                biggers.push_back(num);                
            }
        }
        
        smallers = sortArray(smallers);
        biggers = sortArray(biggers);
        smallers.insert(smallers.end(), biggers.begin(), biggers.end());
        return smallers;
    }
};