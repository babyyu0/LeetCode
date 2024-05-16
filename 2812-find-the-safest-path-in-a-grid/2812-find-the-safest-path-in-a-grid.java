import java.util.*;

class Solution {
    class Pos {
        int r, c;
        Pos(int r, int c) {
            this.r = r; this.c = c;
        }
        public String toString() {
            return "(" + r + ", " + c + ")";
        }
    }
    
    int N;
    int[] dr = {0, 1, -1, 0}, dc = {1, 0, 0, -1};
    int[][] safety, counted;
    boolean[][] visited;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
    	List<Pos> thiefs = new ArrayList<>();
        N = grid.size();
        safety = new int[N][N];
        counted = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(grid.get(i).get(j) == 1) {
                    thiefs.add(new Pos(i, j));
                    safety[i][j] = 0;
                    counted[i][j] = 0;
                } else {
                    safety[i][j] = 160000;
                    counted[i][j] = -1;
                }
            }
        }
        
        Queue<Pos> queue = new ArrayDeque<>();
        for(Pos thief: thiefs) {
            queue.add(new Pos(thief.r, thief.c));
        }

        // 안전계수 구하기
        Pos pos; int nr, nc;
        while(!queue.isEmpty()) {
            pos = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                nr = pos.r + dr[i];
                nc = pos.c + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < N && safety[pos.r][pos.c] + 1 < safety[nr][nc]) {
                    safety[nr][nc] = safety[pos.r][pos.c] + 1;
                    queue.add(new Pos(nr, nc));
                }
            }
        }
        
        //printMap(safety);
        return move();
    }
    
    private int move() {
        //int[][] counted = new int[N][N];
        counted[0][0] = safety[0][0];
        
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(safety[o2.r][o2.c], safety[o1.r][o1.c]));
        pq.add(new Pos(0, 0));
        
        Pos pos; int nr, nc;
        while(!pq.isEmpty()) {
            pos = pq.poll();
            if(pos.r == N - 1 && pos.c == N - 1) {
                //printMap(counted);
                return counted[N - 1][N - 1];
            }
            
            for(int i = 0; i < 4; i++) {
                nr = pos.r + dr[i];
                nc = pos.c + dc[i];
                
                if(0 <= nr && nr < N && 0 <= nc && nc < N && counted[nr][nc] == -1) {
                    counted[nr][nc] = Math.min(counted[pos.r][pos.c], safety[nr][nc]); //최소안전계수
                    pq.add(new Pos(nr, nc));
                }
            }
        }
        
        return 0;
    }
    
    private void printMap(int[][] map) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.printf("%02d ", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}