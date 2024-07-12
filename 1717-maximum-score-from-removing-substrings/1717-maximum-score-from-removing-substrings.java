class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack1 = new Stack<>(), stack2 = new Stack<>();
        int point = 0;
        
        char word1 = 'a', word2 = 'b';
        
        if(x < y) {
            word1 = 'b'; word2 = 'a';
            int tmp = x;
            x = y;
            y = tmp;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(!stack1.isEmpty() && stack1.peek() == word1 && s.charAt(i) == word2) {
                stack1.pop();
                point += x;
            } else {
                stack1.push(s.charAt(i));
            }
        }
        
        while(!stack1.isEmpty()) {
            if(!stack2.isEmpty() && stack2.peek() == word1 && stack1.peek() == word2) {
                stack1.pop();
                stack2.pop();
                point += y;
            } else {
                stack2.push(stack1.pop());
            }
        }
        
        return point;
    }
}