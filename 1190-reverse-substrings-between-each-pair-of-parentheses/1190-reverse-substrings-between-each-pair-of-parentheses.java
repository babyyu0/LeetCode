class Solution {
    int i;
    public String reverseParentheses(String s) {
        String answer = "";
        for(;i < s.length() && s.charAt(i) != ')'; i++) {
            if(s.charAt(i) == '(') {
                i++;
                answer += reverseParentheses(s);
            } else {
                answer += s.charAt(i);
            }
        }
        
        if(s.length() != i) {
            String tmp = "";
            for(char c : answer.toCharArray()) {
                tmp = c + tmp;
            }
            
            return tmp;
        }
        
        return answer;
    }
}