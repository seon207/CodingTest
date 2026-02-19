import java.io.*;
import java.util.*;

class Solution {
    static int max, size;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        max = Integer.MIN_VALUE;
        size = dungeons.length;
        visited = new boolean[size];
        explore(dungeons,k,0);
        return max;
    }
    
    public static void explore(int[][] dungeons, int k, int count) {
        max = Math.max(max, count);
        
        
        for(int i = 0; i < size; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                explore(dungeons, k - dungeons[i][1], count+1);
                visited[i] = false;
            }
        }
        
    }
}