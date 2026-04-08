import java.io.*;
import java.util.*;

class Solution {
    static HashSet<String> set;
    public int solution(String dirs) {
        set = new HashSet<>();
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < dirs.length(); i++){
            int nx = x;
            int ny = y;
            char c = dirs.charAt(i);
            if(c == 'U'){
                ny++;
            }else if(c == 'D'){
                ny--;
            }else if(c == 'R'){
                nx++;
            }else if(c == 'L'){
                nx--;
            }
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            if(nx >= -5 && nx <= 5 && ny >= -5 && ny <=5){
                set.add(x + " " + y + " to " + nx + " " + ny);
                set.add(nx + " " + ny + " to " + x + " " + y);
                x = nx;
                y = ny;
            }
        }
        
        int answer = set.size()/2;
        return answer;
    }
}