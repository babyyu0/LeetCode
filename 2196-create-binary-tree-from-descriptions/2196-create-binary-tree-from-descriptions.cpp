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
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
        unordered_map<int, TreeNode*> tmap;
        unordered_set<int> cset;
        
        
        int parent, child, isLeft;
        for(auto& desc : descriptions) {
            parent = desc[0];
            child = desc[1];
            isLeft = desc[2];
            
            cset.emplace(child);
            
            if(tmap.find(parent) == tmap.end()) {
                tmap[parent] = new TreeNode(parent);
            }
            if(tmap.find(child) == tmap.end()) {
                tmap[child] = new TreeNode(child);
            }
            
            if(isLeft) {
                tmap[parent]->left = tmap[child];
            } else {
                tmap[parent]->right = tmap[child];
            }
        }
        
        for(auto& desc : descriptions) {
            if(cset.find(desc[0]) == cset.end()) {
                return tmap[desc[0]];
            }
        }
        
        return new TreeNode();
    }
};