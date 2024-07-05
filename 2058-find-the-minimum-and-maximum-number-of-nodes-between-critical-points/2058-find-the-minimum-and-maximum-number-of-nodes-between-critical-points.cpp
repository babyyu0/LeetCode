/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        vector<int> indexVec;
        indexVec.push_back(-100000);
        int minDist = 100000;
        
        int before = head->val;
        head = head->next;
        
        int i = 1;
        while(head->next != NULL) {
            if(max(before, head->next->val) < head->val || min(before, head->next->val) > head->val) {
                minDist = min(minDist, i - indexVec.back());
                indexVec.push_back(i);
            }
            i++;
            before = head->val;
            head = head->next;
        }
        
        if(indexVec.size() <= 2) return vector<int>({-1, -1});
        return vector<int>({minDist, indexVec.back() - indexVec[1]});
    }
};