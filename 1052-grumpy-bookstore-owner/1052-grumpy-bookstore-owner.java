class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int N = customers.length;
        int[] oriCount = new int[N];
        int[] teqCount = new int[N];
        
        /* 0부터 시작 */
        oriCount[0] = (grumpy[0] + 1) % 2 * customers[0];
        for(int i = 0; i < minutes; i++) {
            teqCount[minutes - 1] += customers[i];
        }
        
        int tmp;
        for(int i = 1; i < N; i++) { //초마다 순회
            oriCount[i] = oriCount[i - 1] + (grumpy[i] + 1) % 2 * customers[i];
            teqCount[i] = Math.max(teqCount[i], teqCount[i - 1] + (grumpy[i] + 1) % 2 * customers[i]);
            
            if(i + minutes > N) continue;
            tmp = oriCount[i - 1];
            for(int j = i; j < i + minutes; j++) {
                tmp += customers[j];
            }
            teqCount[i + minutes - 1] = Math.max(teqCount[i + minutes - 1], tmp);
        }
        
        // System.out.printf("짜증 그대로 둘 때의 Customer Count: %s\n", Arrays.toString(oriCount));
        // System.out.printf("짜증 사용할 때의 Customer Count: %s\n", Arrays.toString(teqCount));
        
        return teqCount[N - 1];
    }
}