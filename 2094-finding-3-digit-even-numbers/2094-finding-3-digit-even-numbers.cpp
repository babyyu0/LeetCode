#include <algorithm>
#include <set>

class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        sort(digits.begin(), digits.end());
        std::set<int> result;
        vector<bool> visit(digits.size(), false);
        std::string str;
        recursion(result, digits, visit, str);

        return vector<int>(result.begin(), result.end());
    }

private:
    void recursion(std::set<int>& result, vector<int> digits, vector<bool>& visit, std::string& str) {
        for(int i = 0; i < digits.size(); i++) {
            if(str.size() == 0 && digits[i] == 0
                || str.size() == 2 && digits[i] % 2 == 1) {
                continue;
            }
            if(visit[i] == false) {
                visit[i] = true;
                str += to_string(digits[i]);
                if(str.size() == 3) {
                    result.insert(stoi(str));
                } else if(str.size() < 3) {
                    recursion(result, digits, visit, str);
                }
                str.pop_back();
                visit[i] = false;
            }
        }
        return;
    }
};