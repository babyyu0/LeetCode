import java.util.*;

class Solution {    
    private int n, m, MAX_VAL;
    private int[][] grid;
    private final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0) {
                    findGold(i, j, new boolean[n][m], new int[n][m]);
                }
            }
        }
        
        return MAX_VAL;
    }
    
    private void findGold(int r, int c, boolean[][] visited, int[][] gold) {
        //System.out.println(grid[r][c] + " 방문");
        gold[r][c] = Math.max(gold[r][c], grid[r][c]); //gold 초기화
        visited[r][c] = true; //방문 처리
        
        int nr, nc;
        for(int i = 0; i < 4; i++) {
            nr = r + dr[i];
            nc = c + dc[i];
            //방문 가능 여부 확인
            if(0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc] && grid[nr][nc] != 0) {
                //System.out.println(grid[nr][nc] + " 진입...");
                gold[nr][nc] = gold[r][c] + grid[nr][nc]; 
                findGold(nr, nc, visited, gold);
            }
        }
        
        MAX_VAL = Math.max(MAX_VAL, gold[r][c]);
        //System.out.println(gold[r][c] + " 값으로 "  + grid[r][c] + " 나가기...");
        visited[r][c] = false; //방문 처리
    }
}