class Solution {
private:
    map<int, int> orderMap;
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        int N = arr1.size();
        int M = arr2.size();
        for(int i = 0; i < M; i++) {
            orderMap.emplace(arr2[i], i);
        }
        
        sort(arr1.begin(), arr1.end());
        for(int i = 0; i < N; i++) {
            if(orderMap.find(arr1[i]) == orderMap.end()) {
                orderMap.emplace(arr1[i], M++);
            }
        }
        
        sort(arr1.begin(), arr1.end(), [this](int a, int b) {
            return orderMap[a] < orderMap[b];
        });
        return arr1;
    }
};