import java.util.*;

class Solution {
    public class Worker {
        Worker(double quality, double wage, double perCost) {
            this.quality = quality;
            this.wage = wage;
            this.perCost = perCost;
        }
        double quality, wage, perCost;
        public String toString() {
            return "Worker {quality=" + quality + ", wage=" + wage + "}";
        }
    }
    
    private double minSum = Double.MAX_VALUE;
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        
        Worker[] workers = new Worker[n];
        for(int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i], (double) wage[i] / quality[i]);
        }
        
        Arrays.sort(workers, Comparator.comparingDouble(o -> o.perCost));
        double qualitySum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            pq.add(workers[i].quality);
            qualitySum += workers[i].quality;
            
            if(pq.size() == k) {
                minSum = Math.min(qualitySum * workers[i].perCost, minSum);
                qualitySum -= pq.poll();
            }
        }
        
        return minSum;
    }
}