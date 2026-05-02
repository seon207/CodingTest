import java.io.*;
import java.util.*;

class Solution {
    int max, min;
    public String solution(String s) {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(s, " ");
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num >= max){
                max = num;
            }
            if(num <= min){
                min = num;
            }
        }
        String answer = min + " " + max;
        return answer;
    }
}