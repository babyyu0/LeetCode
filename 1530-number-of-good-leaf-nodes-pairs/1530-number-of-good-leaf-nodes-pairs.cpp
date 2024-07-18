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
    int countPairs(TreeNode* root, int distance) {
        vector<string> leafs;
        queue<pair<TreeNode*, string>> q;
        q.push(make_pair(root, ""));
        
        pair<TreeNode*, string> p;
        TreeNode* node;
        string dist;
        while(!q.empty()) {
            p = q.front();
            node = p.first;
            dist = p.second;
            q.pop();
            
            if(node->left == NULL && node->right == NULL) { //리프노드
                leafs.push_back(dist);
            } else {
                if(node->left != NULL) q.push(make_pair(node->left, dist + "L"));
                if(node->right != NULL) q.push(make_pair(node->right, dist + "R"));
            }
        }
        
        int answer = 0, k;
        
        for(int i = 0; i < leafs.size(); i++) {
            for(int j = i + 1; j < leafs.size(); j++) {
                k = 0;
                while(leafs[i][k] == leafs[j][k]) {
                    k++;
                }
                
                if(leafs[i].size() + leafs[j].size() - k * 2 <= distance) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
};