class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> expected;
        for(int n : heights) {
            expected.push_back(n);
        }
        sort(expected.begin(), expected.end());
        
        int answer = 0;
        for(int i = 0; i < expected.size(); i++){
            if(expected[i] != heights[i]) answer++;
        }
        
        return answer;
    }
};