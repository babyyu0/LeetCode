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
    private int[] toDelete;
    private Queue<TreeNode> queue;
    private TreeNode makeNodes(TreeNode node) {
        if(node == null) return null;
        for(int d : toDelete) { //삭제되는 요소 찾기
            if(node.val == d) {
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                return null;
            }
        }
        
        TreeNode madeNode = new TreeNode(node.val);
        madeNode.left = makeNodes(node.left);
        madeNode.right = makeNodes(node.right);
        
        return madeNode;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.queue = new ArrayDeque<>();
        this.toDelete = to_delete;
        
        queue.add(root);
        List<TreeNode> answer = new ArrayList<>();
        
        TreeNode node;
        while(!queue.isEmpty()) {
            root = makeNodes(queue.poll());
            if(root != null) answer.add(root);
        }
        
        return answer;
    }
}