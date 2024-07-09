class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        double waitingSum = 0;
        int curTime = 0;
        
        for(auto& customer : customers) {
            waitingSum += max(0, curTime - customer[0]) + customer[1];
            curTime = max(curTime, customer[0]) + customer[1];
        }
        
        return waitingSum / (double) customers.size();
    }
};