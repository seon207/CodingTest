import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i = 0; i < s.length; i++){
            String result = exchange(s[i]);
            answer[i] = result;
        }
        return answer;
    }
    
    public static String exchange(String s){
        int size = s.length();
        char[] arr = new char[size];
        int top = 0;
        int count = 0;
        for(int i = 0; i < size; i++){
            char c = s.charAt(i);
            arr[top++] = c;
            
            if(top >= 3){
            if(arr[top-3] == '1' && arr[top-2] == '1' && arr[top-1] == '0'){
                top -= 3;
                count++;
            }
            }
        }
        
        String left = new String(arr, 0, top);
        
        int idx = left.lastIndexOf('0');
        StringBuilder sb = new StringBuilder();
        if(idx == -1){  // 0 없음 -> 맨앞
            for(int i = 0; i < count; i++){
                sb.append("110");
            }
            sb.append(left);
        }else{
            sb.append(left, 0, idx + 1);
            for(int i = 0; i<count; i++){
                sb.append("110");
            }
            sb.append(left.substring(idx + 1));
        }
        return sb.toString();
    }
}