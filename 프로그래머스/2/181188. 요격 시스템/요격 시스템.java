import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a,b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        int end = targets[0][1];
        int answer = 1;
        for(int i = 1; i<targets.length; i++){
            int start = targets[i][0];
            if(start < end){    // 겹침
                end = Math.min(targets[i][1], end);
            }else{  // 안겹침
                answer++;
                end = targets[i][1];
            }
        }
        
        return answer;
    }
}