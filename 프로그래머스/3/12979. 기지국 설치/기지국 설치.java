import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        long answer = 0;
        long end = 0;  // 끝부분
        for(int i = 0; i<stations.length; i++){
            long start = stations[i] - w;  // 시작부분
            long distance = start - end - 1; // 전파 안닿는 곳
            
            if(distance > 0){
                answer += (distance + (2*w+1) - 1) / (2*w+1);
            }
            
            end = stations[i] + w; // 끝부분
        }
        
        // 마지막 기지국 이후
        if(end < n){
            long distance = n-end;
            answer += (distance + (2*w+1) - 1) / (2*w+1);
        }

        return (int) answer;
    }
}