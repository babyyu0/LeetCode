class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int N = hand.length;
        boolean[] visited = new boolean[N];
        
        int sel, count, groupCnt = 0;
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            
            groupCnt++;
            sel = hand[i];
            //System.out.printf("[%d: %d", i, sel);
            count = 1;
            visited[i] = true;
            for(int j = i + 1; j < N; j++) {
                if(visited[j] || hand[j] == sel) continue;
                if(hand[j] == sel + 1) {
                    sel++;
                    //System.out.printf(", %d: %d", j, sel);
                    visited[j] = true;
                    if(++count == groupSize) {
                        break;
                    }
                }
            }
            //System.out.printf("]\n");
            if(count < groupSize) return false;
        }
        
        return true;
    }
}