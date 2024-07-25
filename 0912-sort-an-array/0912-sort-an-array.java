class Solution {
    private List<Integer> quickSort(List<Integer> list) {
        // System.out.println("List: " + list);
        if(list.size() <= 1 || Collections.max(list) == Collections.min(list)) {
            return list;
        }
        
        double pivot = (Collections.max(list) + Collections.min(list)) / 2.0;
        List<Integer> smallerList = new ArrayList<>();
        List<Integer> biggerList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) <= pivot) {
                smallerList.add(list.get(i));
            } else {
                biggerList.add(list.get(i));
            }
        }
        
        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(quickSort(smallerList));
        sortedList.addAll(quickSort(biggerList));
        
        return sortedList;
    }
    
    public int[] sortArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums) list.add(num);
        list = quickSort(list);
        for(int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}