import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        
        for(int i = 0; i < n; i++){
            // 큰 값부터 확인
            int cited = citations[n - i - 1];
            int paper = i + 1;
            
            if(cited >= paper){
                h = paper;
            } else{
                break;
            }
        }
        
        return h;
    }
}
