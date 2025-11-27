import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static HashSet<HashSet<String>> result;
    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        find(0, user_id, banned_id, new HashSet<>());
        
        
        int answer = result.size();
        
        return answer;
    }
    
    public void find(int depth, String[] user_id, String[] banned_id, HashSet<String> set){
        // 전부 확인함
        if(depth == banned_id.length){
            result.add(set);
            return;
        }
        
        for(int i = 0; i < user_id.length; i++){
            if(set.contains(user_id[i])) continue;
            
            if(check(user_id[i], banned_id[depth])){
                set.add(user_id[i]);
                find(depth + 1, user_id, banned_id, new HashSet<>(set));
                set.remove(user_id[i]);
            }
        }
    }
    
    public boolean check(String user, String ban){
        if(user.length()!= ban.length()){
            return false;
        }
        
        for(int i = 0; i < user.length(); i++){
            if(ban.charAt(i) != '*' && ban.charAt(i)!=user.charAt(i)){
                return false;
            }
        }
        
        return true;
        
    }
}