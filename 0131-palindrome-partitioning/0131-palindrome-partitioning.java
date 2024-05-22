class Solution {
    List<List<String>> answer;
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        findPalindrome(s, new ArrayList<>());
        
        return answer;
    }
    private void findPalindrome(String s, List<String> selected) {
        if(s.isBlank()) {
            answer.add(new ArrayList<>(selected));
            return;
        }
        String subS, sub1, sub2;
        for(int i = 1; i <= s.length(); i++) {
            subS = s.substring(0, i); //자른 문자열
            //System.out.printf("자른 문자열 %s 검사:\n", subS);
            sub1 = subS.substring(0, i / 2);
            sub2 = reverseStr(subS.substring(i % 2 == 0 ? i / 2 : i / 2 + 1, i));
            //System.out.printf("\t반 자른 문자열 %s와 %s 회문 검사\n", sub1, sub2);
            if(sub1.equals(sub2) || subS.length() == 1) {
                selected.add(subS.toString());
                findPalindrome(s.substring(i, s.length()), selected);
                selected.remove(selected.size() - 1);
            }
        }
    }
    
    private String reverseStr(String s) {
        StringBuilder result = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        
        return result.toString();
    }
}