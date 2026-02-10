import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        int loc = 0;
        for(int i = 0; i < s.length; i++){
            int count = 0;
            int idx = 0;
            String str = s[i];
            char[] arr = new char[str.length()];
            for(int j = 0; j < str.length(); j++){
                arr[idx++] = str.charAt(j);
                if(idx >= 3){   // 110 모임
                    if(arr[idx-3] == '1' && arr[idx-2] == '1' && arr[idx-1] == '0'){
                        count++;
                        idx-=3;
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            String nstr = new String(arr, 0, idx);  // 처음부터 idx 위치까지 새로운 문자열
            int last = nstr.lastIndexOf('0');    // 마지막 0 위치
            if(last == -1){  // 맨앞
                for(int k = 0 ; k < count; k++){
                    sb.append("110");
                }
                sb.append(nstr);
            }else{
                sb.append(nstr, 0, last + 1);
                for(int k = 0; k < count; k++){
                    sb.append("110");
                }
                sb.append(nstr.substring(last + 1));
            }
            answer[loc++] = sb.toString();
        }
        
        return answer;
    }
}