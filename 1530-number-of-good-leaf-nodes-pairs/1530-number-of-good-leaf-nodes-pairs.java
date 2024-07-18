/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        TreeNode node;
        String dist;
        Pair(TreeNode node, String dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int countPairs(TreeNode root, int distance) {
        List<String> leafs = new ArrayList<>();
        
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, ""));
        
        Pair pair;
        TreeNode node; String dist;
        while(!queue.isEmpty()) {
            pair = queue.poll();
            
            if(pair.node.left == null && pair.node.right == null) { //리프노드
                leafs.add(pair.dist);
            } 
            
            if(pair.node.left != null) {
                queue.add(new Pair(pair.node.left, pair.dist + "L"));
            } if(pair.node.right != null) {
                queue.add(new Pair(pair.node.right, pair.dist + "R"));
            }
        }
        
        // System.out.println(leafs);
        
        int answer = 0, k = 0; String fleaf, sleaf;
        for(int i = 0; i < leafs.size(); i++) {
            for(int j = i + 1; j < leafs.size(); j++) {
                k = 0;
                fleaf = leafs.get(i);
                sleaf = leafs.get(j);
                while(k < fleaf.length() && k < sleaf.length() && fleaf.charAt(k) == sleaf.charAt(k)) {
                    k++;
                }
                if (fleaf.length() + sleaf.length() - k * 2 <= distance)  {
                    answer++;
                }
            }
        }
        return answer;
    }
}