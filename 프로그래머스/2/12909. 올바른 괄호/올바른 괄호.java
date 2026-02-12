import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                right++;
            }else{
                left++;
            }
            
            if(right > left){ answer = false;
                             break;
                            }
            
        }
        
        if(right!=left){
            answer = false;
        }

        return answer;
    }
}