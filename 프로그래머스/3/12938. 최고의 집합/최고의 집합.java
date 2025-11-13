import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        if(n > s){
            return new int[]{-1};
        }else{
            answer = new int[n];
            int mid = s / n;
            int rest = s % n;
            if(mid == 0){
                return new int[]{-1};
            }
            
            Arrays.fill(answer, mid);
            
            for(int i = 0; i<rest; i++){
                answer[i]++;
            }
            
            Arrays.sort(answer);
            }
        return answer;
    }
}