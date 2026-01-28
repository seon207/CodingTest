import java.io.*;
import java.util.*;

class Solution {
    static String[] num = {"4","1","2"};   // 0은 4로 대체
    public String solution(int n) {
        String answer = "";
        while(n > 0){
            int left = n % 3;
            n = (n-1)/3;
            answer = num[left] + answer; 
        }
        return answer;
    }
}