class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        vector<string> answer;
        vector<string> tmp;
        
        string cc;
        for(auto& c : words[0]) { //첫번째 값 삽입
            cc = c;
            answer.push_back(cc);
        }
        
        for(auto& word: words) {
            for(auto& c : word) {
                for(int i = 0; i < answer.size(); i++) {
                    if(answer[i][0] == c) {
                        tmp.push_back(answer[i]);
                        answer.erase(answer.begin() + i);
                        break;
                    }
                }
            }
            answer.resize(tmp.size());
            for(int i = 0; i < tmp.size(); i++) {
                answer[i] = tmp[i];
            }
            tmp.clear();
        }
        return answer;
    }
    
private:
    void printVector(vector<string> v) {
        cout << "[";
        for(auto& s : v) {
            cout << s << " ";
        }
        cout << "]" << endl;
    }
};