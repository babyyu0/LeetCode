import java.util.*;

class Solution {
    private List<Integer> peopleList;
    public int numRescueBoats(int[] people, int limit) {
        int answer = 0;
        peopleList = new ArrayList<>();
        for (int p : people) {
            peopleList.add(p);
        }
        
        int left = 0, right = people.length - 1, count = people.length;
        Collections.sort(peopleList, Collections.reverseOrder());
        Arrays.sort(people);
        while(count != 0 && left != right) {
            if(people[left] + people[right] <= limit) {
                left++;
                count--;
            }
            right--;
            count--;
            answer++;
        }
        if(left == right) answer++;
        
        return answer;
    }
}