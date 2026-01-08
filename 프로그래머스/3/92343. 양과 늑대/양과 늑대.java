import java.io.*;
import java.util.*;

class Solution {
    static int max;
    public int solution(int[] info, int[][] edges) {
        max = Integer.MIN_VALUE;
        calc(info, edges, new boolean[info.length], 0, 0, 0);
        
        return max;
    }
    
    public static void calc(int[] info, int[][] edges, boolean[] visited, int idx, int sheep, int wolf){
        visited[idx] = true;
        
        if(info[idx] == 0){ // 양일 때
            sheep += 1;
            max = Math.max(max, sheep);
        }else {
            wolf += 1;
        }
        
        if(sheep <= wolf){
            return;
        }
        
        
        for(int[] now : edges){
            int s = now[0];
            int e = now[1];
            if(visited[s] && !visited[e]){    // 다음 방문 안했을 때
                boolean[] next = new boolean[info.length];
                
                for(int i = 0; i < info.length; i++){
                    next[i] = visited[i];
                }
                
                calc(info, edges, next, e, sheep, wolf);
            }
        }
    }
}