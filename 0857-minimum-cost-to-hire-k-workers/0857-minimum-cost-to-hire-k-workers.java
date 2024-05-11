import java.util.*;

class Solution {
    public class Worker {
        Worker(int quality, double perCost) {
            this.quality = quality;
            this.perCost = perCost;
        }
        double quality, perCost;
    }
    
    private double minSum = Double.MAX_VALUE;
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length; //노동자 수
        double minSum = Double.MAX_VALUE; //최소 금액
        
        Worker[] workers = new Worker[n]; //임금 기대치를 계산할 노동자 배열
        for(int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], (double) wage[i] / quality[i]);
        }
        
        //품질에 따른 임금 기대 비율을 오름차순으로 정렬
        Arrays.sort(workers, Comparator.comparingDouble(o -> o.perCost));
        double qualitySum = 0; //품질 합계
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder()); //품질 내림차순 삽입
        for(int i = 0; i < n; i++) {
            pq.add(workers[i].quality); //i번째 노동자의 품질 삽입
            qualitySum += workers[i].quality; //더하기
            
            if(pq.size() == k) { //현재까지 Queue에 담긴 k명의 노동자 수
                minSum = Math.min(qualitySum * workers[i].perCost, minSum); //해당 기대비율에 속하는 k명의 최소임금자 계산
                qualitySum -= pq.poll(); //가장 높은 품질 (비싼 임금) 제외
            }
        }
        
        return minSum;
    }
}