class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        combination(0, 0, nums, new ArrayList<>());
        return list;
    }
    private void combination(int start, int count, int[] nums, List<Integer> selected) {
        list.add(new ArrayList<>(selected));
        if(count == nums.length) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            selected.add(nums[i]);
            combination(i + 1, count + 1, nums, selected);
            selected.remove(selected.size() - 1);
        }
    }
}