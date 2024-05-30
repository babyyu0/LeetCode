class Solution {
    public int countTriplets(int[] arr) {
        int N = arr.length;
        int[][] xorList = new int[N][N];
        for(int i = 0; i < N; i++) {
            xorList[i][i] = arr[i];
            for(int j = i + 1; j < N; j++) {
                xorList[i][j] = xorList[i][j - 1] ^ arr[j];
            }
        }
        
        int a, b;
        int answer = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                a = xorList[i][j - 1];
                for(int k = j; k < arr.length; k++) {
                    b = xorList[j][k];
                    if(a == b) answer++;
                }
            }
        }
        return answer;
    }
}