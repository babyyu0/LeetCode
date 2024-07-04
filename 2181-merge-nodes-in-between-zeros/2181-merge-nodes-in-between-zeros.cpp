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
    ListNode* mergeNodes(ListNode* head) {
        ListNode* node = new ListNode(0);
        ListNode* answer = node;
        head = head->next;
        int n = 0;
        
        while(head->next != NULL) {
            if(head->val == 0) {
                node->next = new ListNode(n);
                n = 0;
                node = node->next;
            } else {
                n += head->val;
            }
            
            head = head->next;
        }
        
        node->next = new ListNode(n);
        return answer->next;
    }
};