import java.util.*;

class Solution {
    private List<String> dictionary;
    public String replaceWords(List<String> dictionary, String sentence) {
        this.dictionary = dictionary;
        Collections.sort(this.dictionary, Comparator.comparingInt(o -> o.length()));
        StringBuilder answer = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(sentence);
        String s;
        while(st.hasMoreTokens()) {
            s = search(st.nextToken());
            answer.append(s).append(" ");
        }
        
        return answer.toString().trim();
    }
    private String search(String s) {
        int count;
        for(String d : dictionary) {
            count = 0;
            if(d.length() > s.length()) continue;
            for(int i = 0; i < d.length(); i++) {
                if(s.charAt(i) != d.charAt(i)) break;
                count++;
            }
            if(count == d.length()) return d;
        }
        
        return s;
    }
}