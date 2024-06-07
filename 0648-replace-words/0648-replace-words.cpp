class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        sort(dictionary.begin(), dictionary.end());
        string answer = "";
        
        istringstream ss(sentence);
        string buffer;
        
        int count;
        while(getline(ss, buffer, ' ')) {
            for(string d : dictionary) {
                count = 0;
                for(int i = 0; i < d.size(); i++) {
                    if(d[i] != buffer[i]) break;
                    count++;
                }
                
                if(count == d.size()) {
                    buffer = d;
                    break;
                }
            }
            
            answer += buffer + " ";
        }
        
        answer.pop_back();
        return answer;
    }
};