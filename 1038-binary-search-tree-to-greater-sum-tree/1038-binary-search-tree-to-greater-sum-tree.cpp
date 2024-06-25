/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int nsum = 0;
    TreeNode* bstToGst(TreeNode* root) {
        nodeSum(root);
        
        return root;
    }
    
    void nodeSum(TreeNode* node) {
        if(node == NULL) return;
        
        nodeSum(node->right);
        
        nsum += node->val;
        node->val = nsum;
        
        nodeSum(node->left);
    }
};