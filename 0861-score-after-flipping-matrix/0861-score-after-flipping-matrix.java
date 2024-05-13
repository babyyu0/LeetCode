import java.util.Arrays;

class Solution {
    private int n, m, answer;
    private int[][] grid;
    public int matrixScore(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        
        // 행 살피기
        for(int i = 0; i < n; i++) {
            if(grid[i][0] == 0) {
                for(int j = 0; j < m; j++) {
                    grid[i][j] = (grid[i][j] + 1) % 2;
                }
                //printGrid();
            }
        }
        
        // 열 살피기
        int zero;
        for(int j = 0; j < m; j++) {
            zero = 0;
            for(int i = 0; i < n; i++) {
                zero += (grid[i][j] == 0) ? 1 : 0;
            }
            
            if(zero > n - zero) {  // 1의 개수보다 0의 개수가 더 많을 때
                for(int i = 0; i < n; i++) {
                    grid[i][j] = (grid[i][j] + 1) % 2;
                }
                //printGrid();
            }
        }
        
        // 비트 계산
        String str;
        for(int i = 0; i < n; i++) {
            str = "";
            for(int j = 0; j < m; j++) {
                str += grid[i][j];
            }
            answer += Integer.parseInt(str, 2);
        }
        
        return answer;
    }
    
    private void printGrid() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}