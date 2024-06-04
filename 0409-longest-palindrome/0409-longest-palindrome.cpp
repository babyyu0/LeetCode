class Solution {
public:
    int longestPalindrome(string s) {
        map<char, int> cmap;
        for(auto& c : s) {
            if(!cmap.contains(c)) {
                cmap.emplace(c, 0);
            }
            cmap[c]++;
        }
        
        int answer = 0;
        for(auto& m : cmap) {
            answer += (m.second - m.second % 2);
            
        }
        return answer < s.size() ? answer + 1 : answer;
    }
};