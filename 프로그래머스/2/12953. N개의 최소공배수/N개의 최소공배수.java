import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        answer = lcm(arr[0], arr[1]);
        
        for(int i = 2; i < arr.length; i++){
                answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    public int gcd(int a, int b){
        if(b == 0) return a;
        
        return gcd(b, a % b);
    }
    
    public int lcm(int a, int b){
        return a * b / gcd(a,b);
    }
}