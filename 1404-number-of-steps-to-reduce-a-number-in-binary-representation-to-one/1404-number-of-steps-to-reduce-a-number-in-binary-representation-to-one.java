import java.math.BigInteger;

class Solution {
    BigInteger two;
    public int numSteps(String s) {
        BigInteger one = new BigInteger("1");
        two = new BigInteger("2");
        BigInteger n = calBinary(s);
        System.out.println(n);
        
        int answer = 0;
        while(n.compareTo(one) > 0) {
            if(n.mod(two).intValue() == 1) {
                answer++;
                n = n.add(one);
            }
            answer++;
            n = n.divide(two);
        }
        
        return answer;
    }
    private BigInteger calBinary(String s) {
        BigInteger sum = new BigInteger("0");
        BigInteger bin = new BigInteger("1");
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') sum = sum.add(bin);
            bin = bin.multiply(two);
        }
        return sum;
    }
}