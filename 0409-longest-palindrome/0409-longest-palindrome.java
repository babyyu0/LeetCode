class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) % 2 == 0) {
                answer += map.get(c);
                map.put(c, map.get(c) % 2);
            }
        }
        
        return answer < s.length() ? answer + 1 : answer;
    }
}