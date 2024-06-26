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
    vector<int> nnums;
    TreeNode* setNodes(int left, int right) {
        if(left + 1 == right) {
            return new TreeNode(nnums[right], new TreeNode(nnums[left], NULL, NULL), NULL);
        } else if (left == right) {
            return new TreeNode(nnums[right], NULL, NULL);
        }
        int mid = (left + right) / 2;
        return new TreeNode(nnums[mid], setNodes(left, mid - 1), setNodes(mid + 1, right));
    }
    TreeNode* balanceBST(TreeNode* root) {
        vector<TreeNode*> queue;
        queue.push_back(root);
        
        TreeNode* node;
        while(!queue.empty()) {
            node = queue[0];
            queue.erase(queue.begin());
            nnums.push_back(node->val);
            
            if(node->left != NULL) queue.push_back(node->left);
            if(node->right != NULL) queue.push_back(node->right);
        }
        sort(nnums.begin(), nnums.end());
        
        return setNodes(0, nnums.size() - 1);
    }
};