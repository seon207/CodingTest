import java.io.*;
import java.util.*;

class Solution {
    static Map<String, Integer> w;
    static Map<String, Integer> dc;
    static boolean flag;
    public int solution(String[] want, int[] number, String[] discount) {
        
        w = new HashMap<>();
        dc = new HashMap<>();
        flag = true;
        int answer = 0;
        
        for(int i = 0; i < want.length; i++){
            w.put(want[i], number[i]);
        }
        
        for(int i = 0; i + 10 <= discount.length; i++){
            flag = true;
            dc = new HashMap<>();
            
            for(int j = i; j < i + 10; j++){
                String stuff = discount[j];
                dc.put(stuff, dc.getOrDefault(stuff, 0) + 1);
            }
            
            for(String s : want){
                if(w.get(s) != dc.get(s)){  // 다 구매할 수 없음
                    flag = false;
                    break;
                }
            }
            
            answer += flag? 1:0;
        }
        
        return answer;
    }
}