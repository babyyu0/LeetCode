class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        vector<bool> visited(names.size());
        vector<string> sorted;
        
        int maxHeight, maxHeightIdx;
        for(int i = 0; i < names.size(); i++) {
            maxHeightIdx = -1;
            maxHeight = 0;
            for(int i = 0; i < names.size(); i++) {
                if(visited[i] == false && heights[i] > maxHeight) {
                    maxHeight = heights[i];
                    maxHeightIdx = i;
                }
            }
            
            if(maxHeightIdx == -1) break;
            visited[maxHeightIdx] = true;
            sorted.push_back(names[maxHeightIdx]);
            
        }
        
        return sorted;
    }
};