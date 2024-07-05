class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        vector<int> answer;
        
        int i, greater;
        
        for(auto& num1 : nums1) {
            i = 0;
            greater = -1;
            while(nums2[i++] != num1);
            for(;i < nums2.size(); i++) {
                if(nums2[i] > num1) {
                    greater = nums2[i];
                    break;
                }
            }
            answer.push_back(greater);
        }
        
        return answer;
    }
};