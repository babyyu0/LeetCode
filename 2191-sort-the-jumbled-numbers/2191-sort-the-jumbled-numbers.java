class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        ArrayList<int[]> list = new ArrayList<>();
        int mappedNum, tenPow, num;
        for(int i = 0; i < nums.length; i++) {
            mappedNum = 0;
            tenPow = 1;
            num = nums[i];
            
            while(num != 0) {
                mappedNum += mapping[num % 10] * tenPow;
                tenPow *= 10; num /= 10;
            }
            
            list.add(new int[]{nums[i], nums[i] != 0 ? mappedNum : mapping[0]});
        }
        
        Collections.sort(list, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i)[0];
        }
        return nums;
    }
}