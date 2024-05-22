class Solution {
    List<List<String>> answer;
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        findPalindrome(new StringBuilder(s), new ArrayList<>());
        
        return answer;
    }
    private void findPalindrome(StringBuilder sb, List<String> selected) {
        if(sb.isEmpty()) {
            answer.add(new ArrayList<>(selected));
            //System.out.println("* selected : " + selected);
            return;
        }
        //System.out.printf("문자열 %s 검사:\n", sb);
        StringBuilder subS, sub1, sub2;
        for(int i = 1; i <= sb.length(); i++) {
            subS = new StringBuilder(sb.substring(0, i)); //자른 문자열
            //System.out.printf("자른 문자열 %s 검사:\n", subS);
            sub1 = new StringBuilder(subS.substring(0, i / 2));
            sub2 = new StringBuilder(subS.substring(i % 2 == 0 ? i / 2 : i / 2 + 1, i)).reverse();
            //System.out.printf("\t반 자른 문자열 %s와 %s 회문 검사\n", sub1, sub2);
            if(sub1.toString().equals(sub2.toString()) || subS.length() == 1) {
                selected.add(subS.toString());
                findPalindrome(sb.delete(0, i), selected);
                sb.insert(0, subS);
                selected.remove(selected.size() - 1);
            }
        }
    }
}