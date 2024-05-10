import java.util.*;

class Solution {
    class Fraction {
        Fraction(int num, int denom) {
            this.num = num;
            this.denom = denom;
        }
        int num;
        int denom;
        public int[] toArr() {
            return new int[]{this.num, this.denom};
        }
        public String toString() {
            return num +  "/" + denom;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        List<Fraction> list = new ArrayList<>();
        for(int i = n -1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                list.add(new Fraction(arr[j], arr[i]));
            }
        }
        list.sort((o1, o2) -> {
            return Double.compare((double) o1.num / o1.denom, (double) o2.num / o2.denom);
        });
        
        return list.get(k - 1).toArr();
    }
}