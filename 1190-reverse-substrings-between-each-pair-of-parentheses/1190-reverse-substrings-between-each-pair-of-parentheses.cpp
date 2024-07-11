class Solution {
public:
    int i = 0;
    string reverseParentheses(string s) {
        string answer = "";
        for(;i < s.size() && s[i] != ')'; i++) {
            if(s[i] == '(') {
                i++;
                answer += this->reverseParentheses(s);
            } else {
                answer += s[i];
            }
        }
        
        if(i < s.size()) reverse(answer.begin(), answer.end());
        return answer;
    }
};