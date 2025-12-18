import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int[] result = new int[100001];    // n을 표현하는 경우의 수
        result[0] = 1;
        for(int m: money){
            for(int j = m; j <= n; j++){
                result[j] += result[j - m];
            }
        }
        
        int answer = result[n];
        return answer;
    }
}