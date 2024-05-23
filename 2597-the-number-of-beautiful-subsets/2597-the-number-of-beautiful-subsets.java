class Solution {
    private int answer, k;
    private int[] nums;
    public int beautifulSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        combination(0, 0, new ArrayList<>());
        
        return answer;
    }
    private void combination(int start, int count, List<Integer> list) {
        if(count == nums.length) return;
        
        boolean flag;
        for(int i = start; i < nums.length; i++) {
            flag = true;
            for(int j = 0; j < list.size(); j++) {
                if(Math.abs(nums[i] - list.get(j)) == k) {
                    flag = false;
                    break;
                }
            }
            if(!flag) continue;
            answer++;
            list.add(nums[i]);
            combination(i + 1, count + 1, list);
            list.remove(list.size() - 1);
        }
    }
}