//import java.util.*;

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid[0].length - 2;
        int[][] answer = new int[n][n];
        
        int max;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                max = 0;
                for(int k = i; k <= i + 2; k++) {
                    for(int l = j; l <= j + 2; l++) {
                        max = Math.max(grid[k][l], max);
                    }
                }
                answer[i][j] = max;
            }
        }
        
        return answer;
    }
}