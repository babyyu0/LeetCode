class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> orderMap = new HashMap<>();
        int N = arr1.length;
        int M = arr2.length;
        for(int i = 0; i < M; i++) {
            orderMap.put(arr2[i], i);
        }
        //System.out.println(orderMap);
        Arrays.sort(arr1);
        int tmp; boolean flag;
        for(int re = 0; re < N; re++) {
            flag = false;
            for(int i = 0; i < N - 1; i++) {
                if(!orderMap.containsKey(arr1[i])) {
                    orderMap.put(arr1[i], M++);
                    //System.out.println(orderMap);
                }
                if(!orderMap.containsKey(arr1[i + 1])) {
                    orderMap.put(arr1[i + 1], M++);
                    //System.out.println(orderMap);
                }
                if(orderMap.get(arr1[i]) > orderMap.get(arr1[i + 1])) {
                    flag = true;
                    tmp = arr1[i];
                    arr1[i] = arr1[i + 1];
                    arr1[i + 1] = tmp;
                }
            }
            if(!flag) break;
        }
        
        return arr1;
    }
}