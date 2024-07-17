/**
 * Definition for a binary tree node->
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
    queue<TreeNode*> q;
    vector<int> del;
    TreeNode* makeNodes(TreeNode* node) {
        if(node == NULL) {
            return NULL;
        } else if(find(del.begin(), del.end(), node->val) != del.end()) {
            q.push(node->left);
            q.push(node->right);
            return NULL;
        }
        TreeNode* madeNode = new TreeNode(node->val);
        madeNode->left = makeNodes(node->left);
        madeNode->right = makeNodes(node->right);
        
        return madeNode;
    }
    
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        vector<TreeNode*> answer;
        q.push(root);
        del = to_delete;
        
        while(!q.empty()) {
            if (q.front() == NULL) {
                q.pop();
                continue;
            }
            root = makeNodes(q.front());
            q.pop();
            if(root != NULL) {
                answer.push_back(root);
            }
        }
        
        return answer;
    }
};