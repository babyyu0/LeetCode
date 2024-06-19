class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        int res = -1;
        set<int> dset;
        vector<int> days;
        for(auto& b : bloomDay) {
            if(dset.contains(b)) {
                continue;
            }
            dset.emplace(b);
            days.push_back(b);
        }
        
        sort(days.begin(), days.end());
        
        int fcnt = 0, bcnt = 0;
        for(int i = days.size() - 1; i >= 0; i--) {
            fcnt = 0; bcnt = 0;
            for(auto& b : bloomDay) {
                if(b <= days[i]) { //해당 날짜에 꽃이 이미 피었을 경우
                    if(++fcnt == k) { //꽃다발을 만들 수 있을 경우
                        if(++bcnt == m) { //꽃다발을 모두 채웠을 경우
                            break;
                        }
                        fcnt = 0;
                    }
                } else { //피지 않은 꽃이 존재할 경우
                    fcnt = 0; //연속이 깨짐
                }
            }
            
            if(bcnt < m) { //해당 날짜부터 더이상 꽃다발을 못 만들면 break
                break;
            }
            res = days[i]; //가장 짧은 날짜로 설정
        }
        
        return res;
    }
};