class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        while(queue.size() > 1) {
            // System.out.println(queue);
            for(int i = 1; i < k; i++) {
                queue.add(queue.remove());
            }
            queue.remove();
        }
        
        return queue.remove();
    }
}