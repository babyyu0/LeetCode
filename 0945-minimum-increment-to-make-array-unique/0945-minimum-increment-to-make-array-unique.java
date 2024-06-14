class Solution {
    public int minIncrementForUnique(int[] nums) {
        int N = nums.length;
        int res = 0;
        Arrays.sort(nums);
        
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        int maxNum = nums[N - 1] + 1;
        stack.add(maxNum);
        set.add(nums[N - 1]);
        
        int tmp;
        for(int i = N - 2; i >= 0; i--) {
            for(int j = nums[i + 1] - 1; j > nums[i]; j--) {
                stack.add(j);
            }
            
            if(set.contains(nums[i])) {
                tmp = stack.pop();
                res += tmp - nums[i];
                set.add(tmp);
            }
            set.add(nums[i]);
            
            if(stack.isEmpty()) {
                stack.add(++maxNum);
            }
        }
        
        
        return res;
    }
}