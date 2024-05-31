class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] selected = new int[2];
        int index = 0;
        for(int i = 0; i < nums.length; i+=2) {
            if(i == nums.length - 1 || nums[i] != nums[i + 1]) {
                selected[index++] = nums[i--];
            }
            if(index == 2) break;
        }
        
        return selected;
    }
}