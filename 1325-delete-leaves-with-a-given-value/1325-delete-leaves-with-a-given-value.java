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

import java.util.*;
class Solution {
    private int target;
    private TreeNode root;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.target = target;
        this.root = root;
        findLeaf(this.root, null, false);
        return this.root;
    }
    
    private void findLeaf(TreeNode node, TreeNode previous, boolean left) {
        if(node.left != null) findLeaf(node.left, node, true);
        if(node.right != null) findLeaf(node.right, node, false);
        
        if(node.left == null && node.right == null) { //리프노드일 때
            //System.out.printf("현재 리프노드 %d 도달", node.val);
            if(node.val == target) {
                //System.out.print(" (제거 대상)");
                if (previous == null) root = null;
                else if(left) previous.left = null;
                else previous.right = null;
            }
            //System.out.println();
            return;
        }
    }
    
    
}