import java.util.*;
class Solution {
    static int[] max, min;
    public int solution(int[][] sizes) {
        max = new int[sizes.length];
        min = new int[sizes.length];
        for(int i = 0; i < sizes.length; i++){
            max[i] = Math.max(sizes[i][0], sizes[i][1]);
            min[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        Arrays.sort(max);
        Arrays.sort(min);
        
        int m = max[sizes.length-1];
        int n = min[sizes.length-1];
        int answer = m*n;
        return answer;
    }
}