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
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        nodeSum(root);
        return root;
    }
    
    private void nodeSum(TreeNode node) {
        if(node == null) {
            return;
        }
        nodeSum(node.right);
        sum += node.val;
        node.val = sum;
        nodeSum(node.left);
    }
}