import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int size = n * (n+1)/2;
        int[] answer = new int[size];
        int num = 1;
        int r = -1;
        int c = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i%3==0){
                    r++;
                }else if(i%3==1){
                    c++;
                }else{
                    r--;
                    c--;
                }
                map[r][c] = num++;
            }
        }
        
        int idx = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == 0) break;
                answer[idx++] = map[i][j];
            }
        }
        
        
        return answer;
    }
}