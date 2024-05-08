import java.util.*;

class Solution {
    private class Score {
        public Score(int score, int index) {
            this.score = score;
            this.index = index;
        }
        int score, index;
        public String toString() {
            return "Score{score=" + this.score + ", index=" + index + "}";
        }
    }
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Score[] iScore = new Score[n];
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            iScore[i] = new Score(score[i], i);
        }
        
        //정렬 진행
        int tmpScore, tmpIndex; boolean flag;
        for(int rep = 0; rep <= n; rep++) {
            flag = false;
            for(int i = 0; i < n - 1; i++) {
                if(iScore[i].score < iScore[i + 1].score) {
                    flag = true;
                    tmpScore = iScore[i].score;
                    tmpIndex = iScore[i].index;
                    iScore[i].score = iScore[i + 1].score;
                    iScore[i].index = iScore[i + 1].index;
                    iScore[i + 1].score = tmpScore;
                    iScore[i + 1].index = tmpIndex; //값 바꾸기
                }
            }
            if(!flag) break;
        }
        answer[iScore[0].index] = "Gold Medal";
        if(n > 1) answer[iScore[1].index] = "Silver Medal";
        if(n > 2) answer[iScore[2].index] = "Bronze Medal";
        
        for(int i = 3; i < n; i++) {
            answer[iScore[i].index] = i + 1 + "";
        }
        
        return answer;
    }
}