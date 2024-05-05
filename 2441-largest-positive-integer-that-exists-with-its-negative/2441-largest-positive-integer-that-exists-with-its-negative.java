import java.util.*;

class Solution {
    public int findMaxK(int[] nums) {
        Integer[] intNums = Arrays.stream(nums).boxed().toArray(Integer[] :: new);
        Arrays.sort(intNums, (o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)) {
                return Integer.compare(o1, o2);
            } else {
                return Integer.compare(Math.abs(o1), Math.abs(o2));
            }
        });
        
        for(int i = intNums.length - 1; 0 < i; i--) {
            if(intNums[i] + intNums[i - 1] == 0) {
                return Math.abs(intNums[i]);
            }
        }
        return -1;
    }
}