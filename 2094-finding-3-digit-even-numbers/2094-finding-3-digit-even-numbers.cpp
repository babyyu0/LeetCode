class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        std::set<int> result;

        int digitSize = digits.size();
        vector<bool> visits(digitSize, false);

        for(int i = 0; i < digitSize; i++) {
            if(digits[i] == 0) {
                continue;
            }
            visits[i] = true;
            for(int j = 0; j < digitSize; j++) {
                if(visits[j] == true) {
                    continue;
                }
                
                visits[j] = true;
                for(int k = 0; k < digitSize; k++) {
                    if(visits[k] == true || digits[k] % 2 == 1) {
                        continue;
                    }

                    result.insert(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
                visits[j] = false;
            }
            visits[i] = false;
        }

        return vector<int>(result.begin(), result.end());
    }
};