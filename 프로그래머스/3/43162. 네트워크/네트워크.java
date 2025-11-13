import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static int network;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                network++;
                find(i, n, computers);
            }
        }
        
        return network;
    }
    
    public static void find(int i, int n, int[][] computers){
        visited[i] = true;
        
        for(int j = 0; j < n; j++){
            if(!visited[j] && computers[i][j] == 1){
                find(j, n, computers);
            }
        }
    }
}
