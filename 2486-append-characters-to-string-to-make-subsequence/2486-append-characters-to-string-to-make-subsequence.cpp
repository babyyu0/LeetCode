class Solution {
public:
    int appendCharacters(string s, string t) {
        int i = 0;
        
        for(auto& c : s) {
            if(c == t[i]) {
                if(++i >= t.size()) break;
            }
        }
        
        return t.size() - i;
    }
};