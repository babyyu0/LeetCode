class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        unordered_map<int, int> freqMap;
        for(auto& n : nums) {
            freqMap[n]++;
        }
        
        sort(nums.begin(), nums.end(), [&](int a, int b) {
            if (freqMap[a] == freqMap[b]) {
                return a > b;
            } else {
                return freqMap[a] < freqMap[b];
            }
        });
        
        return nums;
    }
};