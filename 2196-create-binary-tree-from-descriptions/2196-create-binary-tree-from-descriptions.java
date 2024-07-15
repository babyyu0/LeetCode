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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> tmap = new HashMap<>();
        Set<Integer> parentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        
        int parent, child, isLeft;
        TreeNode parentNode, childNode;
        for(int i = 0; i < descriptions.length; i++) {
            parent = descriptions[i][0];
            child = descriptions[i][1];
            isLeft = descriptions[i][2];
            
            parentSet.add(parent);
            childSet.add(child);
            
            if(!tmap.containsKey(parent)) {
                tmap.put(parent, new TreeNode(parent));
            }
            parentNode = tmap.get(parent);
            
            if(!tmap.containsKey(child)) {
                tmap.put(child, new TreeNode(child));
            }
            childNode = tmap.get(child);
            
            if(isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            // System.out.println(parentNode.toString());
        }
        
        for(int answer : parentSet) {
            if(!childSet.contains(answer)) {
                return tmap.get(answer);
            }
        }
        
        return new TreeNode();
    }
}