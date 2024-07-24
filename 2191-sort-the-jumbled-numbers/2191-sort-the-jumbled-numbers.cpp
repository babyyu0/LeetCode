class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        int count, mappedNum, num;
        unordered_map<int, int> mappedNums;
        for(int i = 0; i < nums.size(); i++) {
            count = 0;
            mappedNum = 0;
            num = nums[i];
            while(num != 0) {
                mappedNum += mapping[num % 10] * pow(10, count++);
                num /= 10;
            }
            mappedNums.insert({nums[i], nums[i] != 0 ? mappedNum : mapping[0]});
        }
        
        sort(nums.begin(), nums.end(), [&](int a, int b) {
            return mappedNums[a] <  mappedNums[b];
        });
            
        return nums;
    }
};