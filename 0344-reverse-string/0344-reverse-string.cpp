class Solution {
public:
    void reverseString(vector<char>& s) {
        char tmp;
        int N = s.size();
        for(int i = 0; i < s.size() / 2; i++) {
            tmp = s[N - i - 1];
            s[N - i - 1] = s[i];
            s[i] = tmp;
        }
    }
};