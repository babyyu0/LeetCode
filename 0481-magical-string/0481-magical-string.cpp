class Solution {
public:
    int magicalString(int n) {
        vector<string> mnum;
        mnum.push_back("1");
        mnum.push_back("2");
        
        string magical = "122";
        int i = 0, before = 2;
        
        while(magical.size() < n) {
            for(int j = 0; j < magical[before] - '0'; j++) {
                magical += mnum[i];
            }
            i = (i + 1) % 2;
            before++;
        }
        
        // cout << magical << endl;
        int answer = 0;
        for(i = 0; i < n; i++) {
            if(magical[i] == '1') {
                answer++;
            }
        }
        
        return answer;
    }
};