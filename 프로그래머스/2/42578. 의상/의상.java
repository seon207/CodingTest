import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String, Integer> map;
    public int solution(String[][] clothes) {
        map = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < clothes.length; i++){
            String name = clothes[i][0];
            String kind = clothes[i][1];
            
            map.put(kind, map.getOrDefault(kind, 0)+1);
        }
        
        
        int answer = 1;
        
        for(int v: map.values()){
            answer *= (v+1);
        }
        return answer - 1;
    }
}