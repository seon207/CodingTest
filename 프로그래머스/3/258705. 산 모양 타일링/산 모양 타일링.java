import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        // 마름모로 끝나는 경우와 끝나지 않는 경우
        int[] end = new int[n];
        int[] notEnd = new int[n];
        
        end[0] = 1;
        if(tops[0] == 1){   // 탑 있을 때 n=1일 때 마름모로 끝나지 않는 경우의 수 3
            notEnd[0] = 3;
        }else{
            notEnd[0] = 2;
        }
        
        for(int i = 1; i < n; i++){
            int ne = tops[i] == 1 ? 3 : 2;
            int e = tops[i] == 1 ? 2 : 1;
            
            notEnd[i] = (notEnd[i-1] * ne + end[i-1] * e) % 10007;
            end[i] = (notEnd[i-1] + end[i-1]) % 10007;
            
        }
        
        int answer = (notEnd[n-1] + end[n-1]) % 10007;
        return answer;
    }
}