import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] dp1 = new int[n]; // 처음 털기
        int[] dp2 = new int[n]; // 처음 안털기
        
        dp1[0] = money[0];
        dp1[1] = money[0];
        
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i = 2; i < n; i++){
            // 현재 집 턴 경우, 안 턴 경우 최대 비교
            dp1[i] = Math.max(dp1[i-1], money[i] + dp1[i-2]);
            dp2[i] = Math.max(dp2[i-1], money[i] + dp2[i-2]);
        }
        
        int answer = Math.max(dp1[n-2], dp2[n-1]);
        return answer;
    }
}