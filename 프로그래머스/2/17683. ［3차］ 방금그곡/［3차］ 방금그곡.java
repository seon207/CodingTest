import java.io.*;
import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;
        
        String melody = convert(m);
        for(int i = 0; i < musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            int playTime = time(info[0], info[1]);
            StringBuilder sb = new StringBuilder();
            
            String tones = convert(info[3]);
            for(int j = 0; j < playTime; j++){
                sb.append(tones.charAt(j % tones.length()));
            }
            
            String title = info[2];
            if(sb.toString().contains(melody) && maxTime < playTime){
                answer = title;
                maxTime = playTime;
            }
            
        }
        return answer;
    }
    
    public static String convert(String s){
        return s.replace("A#", "a").replace("B#", "b").replace("C#", "c").replace("D#", "d").replace("E#", "e").replace("F#", "f").replace("G#", "g");
    }
    
    public static int time(String start, String end){
        String[] s = start.split(":");
        String[] e = end.split(":");
        
        
        int startTime = (Integer.parseInt(s[0]) * 60) + Integer.parseInt(s[1]);
        int endTime = (Integer.parseInt(e[0]) * 60) + Integer.parseInt(e[1]);
        
        return endTime - startTime;
    }
}