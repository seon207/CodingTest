import java.util.*;

class Solution {
    static Map<String, Integer> map;
    public String solution(String[] participant, String[] completion) {
        map = new HashMap<String, Integer>();
        String answer = "";
        
        for(String s: participant){
            map.put(s, map.getOrDefault(s,0) + 1);
        }
        
        for(String s: completion){
            if(map.containsKey(s)){
                map.put(s, map.get(s)-1);
            }
        }
        
        for(String s: map.keySet()){
            if(map.get(s) != 0){
                answer = s;
            }
        }
        
        
        
        return answer;
    }
}