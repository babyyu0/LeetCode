class Solution {
public:
    int minOperations(vector<string>& logs) {
        int toMain = 0;
        for(auto& log : logs) {
            if(log == "../") {
                toMain = max(0, toMain - 1);
            } else if (log != "./") {
                toMain++;
            }
        }
        
        return toMain;
    }
};