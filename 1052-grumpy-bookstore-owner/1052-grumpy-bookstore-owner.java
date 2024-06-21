class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int N = customers.length;
        
        int[] oriCount = new int[N];
        int[] teqCount = new int[N];
        int[] accumulated = new int[N];
        accumulated[0] = customers[0];
        for(int i = 1; i < N; i++) {
            accumulated[i] = accumulated[i - 1] + customers[i];
        }
        
        /* 0부터 시작 */
        oriCount[0] = (grumpy[0] + 1) % 2 * customers[0];
        for(int i = 0; i < minutes; i++) {
            teqCount[minutes - 1] += customers[i];
        }

        for(int i = 1; i < N; i++) { //초마다 순회
            oriCount[i] = oriCount[i - 1] + (grumpy[i] + 1) % 2 * customers[i];
            teqCount[i] = Math.max(teqCount[i], teqCount[i - 1] + (grumpy[i] + 1) % 2 * customers[i]);
            
            if(i + minutes <= N)
                teqCount[i + minutes - 1] = Math.max(
                    teqCount[i + minutes - 1],
                    oriCount[i - 1] + accumulated[i + minutes - 1] - accumulated[i - 1]
                );
        }
        
        // System.out.printf("짜증 그대로 둘 때의 Customer Count: %s\n", Arrays.toString(oriCount));
        // System.out.printf("짜증 사용할 때의 Customer Count: %s\n", Arrays.toString(teqCount));
        
        return teqCount[N - 1];
    }
}