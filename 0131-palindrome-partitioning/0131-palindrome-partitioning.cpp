#include <sstream>

class Solution {
private:
    vector<vector<string>> answer;
    
    void findPalindrome(string s, vector<string> selected) {
        if(s.empty()) {
            answer.push_back(selected);
            return;
        }
        string subS, sub1, sub2;
        for(int i = 1; i <= s.size(); i++) {
            subS.assign(s.begin(), s.begin() + i);
            sub1.assign(subS.begin(), subS.begin() + i / 2);
            sub2.assign(subS.begin() + (i % 2 == 0 ? i / 2: i / 2 + 1), subS.end());
            reverse(sub2.begin(), sub2.end());
            if(subS.size() == 1 || sub1 == sub2) {
                selected.push_back(subS);
                subS.assign(s.begin() + i, s.end());
                findPalindrome(subS, selected);
                selected.pop_back();
            }
        }
    }
public:
    vector<vector<string>> partition(string s) {
        findPalindrome(s, {});
        return answer;
    }
    
};