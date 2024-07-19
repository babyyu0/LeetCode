class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        vector<int> answer;
        int minIdx, count;
        for(int i = 0; i < matrix.size(); i++) { //행 순회
            minIdx = 0;
            count = 0;
            
            for(int j = 1; j < matrix[i].size(); j++) { //행의 최솟값 찾기
                if(matrix[i][j] < matrix[i][minIdx]) minIdx = j;
            }
            
            for(int j = 0; j < matrix.size(); j++) { //열의 최댓값 찾기
                if(matrix[j][minIdx] > matrix[i][minIdx]) break;
                count++;
            }
            
            if(count == matrix.size()) {
                answer.push_back(matrix[i][minIdx]);
            }
        }
        
        return answer;
    }
};