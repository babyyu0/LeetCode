class Solution {
    public char[] reverseString(char[] s) {
        int N = s.length;
        char tmp;
        for(int i = 0; i < N / 2; i++) {
            tmp = s[N - i - 1];
            s[N - i - 1] = s[i];
            s[i] = tmp;
        }
        
        
        return s;
    }
}