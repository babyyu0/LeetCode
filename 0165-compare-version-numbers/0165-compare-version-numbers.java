import java.util.*;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));

        int v1sp, v2sp;
        for(int i = 0; i < Math.max(v1.length, v2.length); i++) {
            v1sp = (v1.length <= i) ? 0 : Integer.parseInt(v1[i]);
            v2sp = (v2.length <= i) ? 0 : Integer.parseInt(v2[i]);
            if(v1sp < v2sp) {
                return -1;
            } else if(v1sp > v2sp) {
                return 1;
            }
        }

        return 0;
    }
}