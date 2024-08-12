class KthLargest {
public:
    vector<int> nvec;
    int gk;
    KthLargest(int k, vector<int>& nums) {
        gk = k;
        nvec = nums;
        sort(nvec.begin(), nvec.end());
    }
    
    int binSearch(int val) {
        int left = 0, right = nvec.size() - 1;
        int mid;
        
        while(left + 1 < right) {
            mid = (left + right) / 2;
            if(nvec[mid] < val) { //현재 인덱스가 값보다 작은 경우
                left = mid;
            } else if (val < nvec[mid]) { //현재 인덱스가 값보다 큰 경우
                right = mid;
            } else {
                return mid;
            }
        }
        // cout << "left: " << left << ", right: " << right << endl;
        
        if(nvec[right] < val) {
            return right + 1;
        } else if(nvec[left] > val) {
            return left;
        }
        
        return left + 1;
    }
    
    int add(int val) {
        int index = 0;
        if(nvec.size() != 0) {
            index = binSearch(val);
        }
        // cout << val << "이 삽입될 인덱스: " << index << endl;
        nvec.insert(nvec.begin() + index, val);
        // cout << "현재 배열: ";
        // for(auto& n : nvec) {
        //     cout << n << " ";
        // }
        // cout << endl;
        return nvec[nvec.size() - gk];
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */