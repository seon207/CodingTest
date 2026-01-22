import java.io.*;
import java.util.*;

class Solution {
    static Map<String, Integer> map;
    public int[] solution(int n, String[] words) {
        map = new HashMap<>();
        int turn = 0;
        map.put(words[0], 1);
        for(int i = 1; i < words.length; i++){
            String bword = words[i-1];
            String word = words[i];
            char last = bword.charAt(bword.length()-1);
            char fword = word.charAt(0);
            if(fword != last){  // 연결되지 않는 단어
                turn = i;
                break;
            }
            
            if(map.get(words[i]) != null){  // 존재하는 단어
                turn = i;
                break;
            }else{  // 존재하지 않음
                map.put(words[i], 1);
            }
            
        }
        
        
        int[] answer = {};
        if(turn == 0){
            answer = new int[]{0,0};
        }else{
            answer = new int[]{turn % n +1, turn / n +1};
        }
        

        return answer;
    }
}