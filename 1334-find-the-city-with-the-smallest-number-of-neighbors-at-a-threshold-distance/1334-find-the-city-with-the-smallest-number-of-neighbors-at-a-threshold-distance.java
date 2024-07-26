class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dists = new int[n][n];
        int[] dCnt = new int[n];
        List<Integer> answerList = new ArrayList<>();
        int minDist = 101;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dists[i][j] = 10001;
            }
            dists[i][i] = 0;
        }
        int from, to, weight;
        
        for(int[] edge : edges) {
            from = edge[0]; to = edge[1]; weight = edge[2];
            dists[from][to] = Math.min(dists[from][to], weight);
            dists[to][from] = Math.min(dists[to][from], weight);
        }
        
        // System.out.println(Arrays.deepToString(dists).replace("],", "], \n"));
        
        for(int x = 0; x < n; x++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j) continue;
                    for(int k = 0; k < n; k++) {
                        dists[i][j] = Math.min(dists[i][j], dists[i][k] + dists[k][j]);
                    }
                    if(x == n - 1) { //마지막 순회일 때
                        if(dists[i][j] <= distanceThreshold) {
                            dCnt[i]++;
                        }
                    }
                }
                if(x == n - 1) { //마지막 순회일 때
                    if(dCnt[i] < minDist) {
                        answerList.clear();
                        minDist = dCnt[i];
                        answerList.add(i);
                    } else if(dCnt[i] == minDist) {
                        answerList.add(i);
                    }
                }
            }
        }
        
        // System.out.println("\n" + Arrays.deepToString(dists).replace("],", "], \n"));
        // System.out.println("Dist Count: " + Arrays.toString(dCnt));
        // System.out.println("Answer List: " + answerList);
        
        Collections.sort(answerList, Collections.reverseOrder());
        return answerList.get(0);
    }
}