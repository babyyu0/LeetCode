class Solution {
private:
    vector<vector<int>> answer;
    void combination(int start, int count, vector<int> nums, vector<int> selected) {
        answer.push_back(selected);
        if(count == nums.size()) return;
        for(int i = start; i < nums.size(); i++) {
            selected.push_back(nums[i]);
            combination(i + 1, count + 1, nums, selected);
            selected.pop_back();
        }
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        combination(0, 0, nums, vector<int>());
        return answer;
    }
};