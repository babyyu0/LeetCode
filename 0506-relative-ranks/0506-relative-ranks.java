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
        Arrays.sort(iScore, (o1, o2) -> Integer.compare(o2.score, o1.score));
        /*int tmpScore, tmpIndex; boolean flag;
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
        }*/
        
        for(int i = 0; i < n; i++) {
            if(i > 2) {
                answer[iScore[i].index] = i + 1 + "";
            } else if (i == 0) {
                answer[iScore[i].index] = "Gold Medal";
            } else if (i == 1) {
                answer[iScore[i].index] = "Silver Medal";
            } else {
                answer[iScore[i].index] = "Bronze Medal";
            }
        }
        
        return answer;
    }
}