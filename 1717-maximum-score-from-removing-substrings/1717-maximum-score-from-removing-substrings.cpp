class Solution {
public:
    int maximumGain(string s, int x, int y) {
        vector<char> stack1, stack2;
        
        char word1 = 'a', word2 = 'b';
        if(x < y) {
            word1 = 'b';
            word2 = 'a';
            
            int tmp = x;
            x = y;
            y = tmp;
        }
        
        int point = 0;
        for(auto& c : s) {
            if(!stack1.empty() && stack1.back() == word1 && c == word2) {
                stack1.pop_back();
                point += x;
            } else {
                stack1.push_back(c);
            }
        }
        for(auto& c : stack1) {
            if(!stack2.empty() && stack2.back() == word2 && c == word1) {
                stack2.pop_back();
                point += y;
            } else {
                stack2.push_back(c);
            }
        }
        
        return point;
    }
};