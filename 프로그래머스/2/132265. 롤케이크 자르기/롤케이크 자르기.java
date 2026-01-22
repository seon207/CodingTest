import java.io.*;
import java.util.*;

class Solution {
    static Map<Integer, Integer> front;
    static Map<Integer, Integer> back;
    public int solution(int[] topping) {
        
        front = new HashMap<>();
        back = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i<topping.length; i++){  // 총 토핑 개수
            front.put(topping[i], front.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i = 0; i<topping.length; i++){
            back.put(topping[i], back.getOrDefault(topping[i],0)+1);
            front.put(topping[i], front.getOrDefault(topping[i], 0)-1);
            
            if(front.get(topping[i]) == 0){
                front.remove(topping[i]);
            }
            
            if(back.size() == front.size()) answer++;
        }
        
        return answer;
    }
}