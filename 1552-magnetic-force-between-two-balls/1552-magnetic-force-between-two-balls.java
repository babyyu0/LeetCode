class Solution {
    private int RES, N, M;
    private int[] position;
    public int maxDistance(int[] position, int m) {
        N = position.length;
        M = m;
        Arrays.sort(position);
        this.position = position;
        
        findDist();
        
        return RES;
    }
    
    private void findDist() {
        int left = 0, right = position[N - 1] - position[0] + 1;
        int mid;
        while(left + 1 < right) {
            mid = (left + right) / 2;
            if(canDist(mid)) {
                RES = Math.max(mid, RES);
                left = mid;
            } else {
                right = mid;
            }
        }
    }
    
    private boolean canDist(int d) {
        int before = position[0];
        int count = 1;
        for(int i = 1; i < N; i++) {
            if(position[i] - before < d) continue;
            if(++count >= M) {
                return true;
            }
            before = position[i];
        }
        
        return false;
    }
}