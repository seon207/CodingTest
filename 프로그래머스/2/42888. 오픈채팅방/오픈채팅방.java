import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String, String> map;
    public String[] solution(String[] record) {
        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();
        for(String s: record){
            StringTokenizer st = new StringTokenizer(s, " ");
            String cmd = st.nextToken();
            String uid = st.nextToken();
            
            if(!cmd.equals("Leave")){
                String name = st.nextToken();
                map.put(uid, name);
            }
        }
        
        int size = 0;
        for(String s: record){
            StringTokenizer st = new StringTokenizer(s, " ");
            String cmd = st.nextToken();
            String uid = st.nextToken();
            if(cmd.equals("Enter")){
                sb.append(map.get(uid) + "님이 들어왔습니다.").append("\n");
                size++;
            }else if(cmd.equals("Leave")){
                sb.append(map.get(uid) + "님이 나갔습니다.").append("\n");
                size++;
            }
        }
        
        
        String[] answer = sb.toString().split("\n");
        return answer;
    }
}