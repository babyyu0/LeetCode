class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        map<int, int> countMap;
        for(auto& n : nums) {
            countMap.insert({n, 0});
            countMap[n]++;
        }
        vector<pair<int, int>> freqVec(countMap.begin(), countMap.end());
        sort(freqVec.begin(), freqVec.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.second > b.second || (a.second == b.second && a.first < b.first);
        });
        
        vector<int> answer(nums.size());
        int idx = nums.size();
        for(auto& pair : freqVec) {
            for(int i = 0; i < pair.second; i++) {
                answer[--idx] = pair.first;
            }
        }
        
        return answer;
    }
};