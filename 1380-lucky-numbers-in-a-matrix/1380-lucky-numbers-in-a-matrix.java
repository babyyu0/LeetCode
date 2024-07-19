class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int minIdx, count;
        for(int i = 0; i < matrix.length; i++) { //행 순회
            minIdx = 0;
            count = 0;
            
            for(int j = 1; j < matrix[i].length; j++) { //행의 최솟값 찾기
                if(matrix[i][j] < matrix[i][minIdx]) minIdx = j;
            }
            
            for(int j = 0; j < matrix.length; j++) { //열의 최댓값 찾기
                if(matrix[j][minIdx] > matrix[i][minIdx]) break;
                count++;
            }
            
            if(count == matrix.length) {
                answer.add(matrix[i][minIdx]);
            }
        }
        
        return answer;
    }
}