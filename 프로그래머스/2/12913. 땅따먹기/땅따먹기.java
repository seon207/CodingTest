import java.io.*;
import java.util.*;

class Solution {
    static int[][] dp;
    static int max;
    int solution(int[][] land) {
        dp = new int[land.length][4];
        max = 0;
        
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                max = 0;
                for(int k = 0; k < 4; k++){
                    if(k == j) continue;
                    // 이전 행 중 최대
                    max = Math.max(max, land[i-1][k]);
                    
                } 
                land[i][j] += max;
            }
        }
        
        int answer = 0;
        for(int j = 0; j < 4; j++){
            answer = Math.max(answer, land[land.length - 1][j]);
        }
        
        return answer;
    }
}