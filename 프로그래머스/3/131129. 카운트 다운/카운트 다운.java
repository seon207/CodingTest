import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int[][] dp = new int[target+1][2];
        
        for(int i = 0; i<=target; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = 0;
        }
        
        dp[0][0] = 0;
        for(int i = 0; i <= target; i++){
            for(int j = 1; j<=20; j++){
                if(i-50 >= 0){    // 불 맞추기 가능
                    if(dp[i][0] > dp[i-50][0]+1){ //더 적게 던지는 경우
                        dp[i][0] = dp[i-50][0]+1;
                        dp[i][1] = dp[i-50][1]+1;
                    }
                    else if(dp[i][0] == dp[i-50][0]+1){ //같은 다트 수 -> 불 or 싱글 더 맞춘 수
                        dp[i][1] = Math.max(dp[i][1], dp[i-50][1]+1); 
                    }
                }
                
                if(i-j>=0){ // 싱글
                    if(dp[i][0] > dp[i-j][0] + 1){  // 더 적게 던지는 경우
                        dp[i][0] = dp[i-j][0] + 1;
                        dp[i][1] = dp[i-j][1] + 1;
                    }else if(dp[i][0] == dp[i-j][0] + 1){   // 같을 때
                        dp[i][1] = Math.max(dp[i][1], dp[i-j][1] + 1);
                    }
                }
                
                if(i-2*j >=0){  // 더블
                    if(dp[i][0] > dp[i-2*j][0] + 1){
                        dp[i][0] = dp[i-2*j][0]+1;
                        dp[i][1] = dp[i-2*j][1];
                    }
                }
                
                if(i-3*j >=0){  // 트리플
                    if(dp[i][0] > dp[i-3*j][0] + 1){
                        dp[i][0] = dp[i-3*j][0] + 1;
                        dp[i][1] = dp[i-3*j][1];
                    }
                }
            }
        }
        
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        return answer;
    }
}