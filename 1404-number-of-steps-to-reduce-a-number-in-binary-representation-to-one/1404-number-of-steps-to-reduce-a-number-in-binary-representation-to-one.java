import java.math.BigInteger;

class Solution {
    //BigInteger two;
    public int numSteps(String s) {
        int N = s.length();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            deque.addLast(s.charAt(i) - '0');
        }
        
        int i, count, answer = 0;
        while(deque.size() != 1) {
            answer++;
            i = deque.pollLast();
            if(i == 1) { //홀수일 때
                count = 0;
                while(!deque.isEmpty() && deque.pollLast() == 1) {
                    count++;
                }
                deque.addLast(1);
                while(count-- > 0) {
                    deque.addLast(0);
                }
                deque.addLast(0);
            }
            // System.out.println(deque.toString().replace(", ", ""));
        }
        
        return answer;
    }
}