class Solution {
    int N, M;
    vector<int> POSITION;
public:
    bool canDist(int d) {
        int count = 1; //첫 번째 공은 확실히 선택
        int before = POSITION[0];
        
        for(int i = 1; i < N; i++) { // 1 index 위치부터 거리 탐색
            if(POSITION[i] - before < d) continue; //선정 거리 미달일 경우
            if(M <= ++count) { //필요 공 개수 이상일 경우
                break;
            }
            before = POSITION[i];
        }
        return M <= count;
    }
    
    int maxDistance(vector<int>& position, int m) {
        N = position.size();
        M = m;
        sort(position.begin(), position.end());
        POSITION = position;
        
        int left = 0, right = position[N - 1] - position[0], mid;
        int res = 0;
        
        if(m == 2){
            return right;
        }
        
        while(left + 1 < right) {
            mid = (left + right) / 2;
            // cout << "LEFT: " << left <<", RIGHT:" << right << endl;
            // cout << "MID: " << mid << endl;
            if(canDist(mid)) {
                res = max(mid, res);
                left = mid; // 거리 늘리기
            } else { //해당 거리로는 공을 놓지 못할 경우
                right = mid; //거리 줄이기
            }
        }
        
        return res;
    }
};