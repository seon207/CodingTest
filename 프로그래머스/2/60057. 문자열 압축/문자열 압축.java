import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count = 1;
        for(int i = 1; i <= s.length()/2; i++){
            String front = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for(int j = i; j <= s.length(); j+=i){
                int idx = Math.min(j + i, s.length());    // s의 길이 넘을 수 없음
                String end = s.substring(j, idx);
                if(front.equals(end)){
                    count++;
                }else{  // 붙이기
                    if(count > 1){
                        sb.append(count);
                    }
                    sb.append(front);
                    count = 1;
                    front = end;
                }
            }
            
            if(count>1){
                sb.append(count);
            }
            sb.append(front);
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }

}