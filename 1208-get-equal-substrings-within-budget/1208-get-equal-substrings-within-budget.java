class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int N = s.length();
        int[] costs = new int[N];
        int answer = 0;
        
        int left = 0, sum = 0;
        for(int i = 0; i < s.length(); i++) {
            costs[i] = Math.abs(t.charAt(i) - s.charAt(i));
            sum += costs[i];
            if(sum <= maxCost) {
                //System.out.printf("%c(%d)부터 %c(%d)까지 변경 가능 (sum = %d)\n", s.charAt(left),left, s.charAt(i), i, sum);
                answer = Math.max(answer, i - left + 1);
            } else {
                sum -= costs[left++];
            }
        }
        
        return answer;
    }
}