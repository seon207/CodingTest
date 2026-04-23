import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static long[] weights;
    static long answer;
    public long solution(int[] a, int[][] edges) {
        list = new ArrayList[a.length];
        visited = new boolean[a.length];
        weights = new long[a.length];
        answer = 0;
        int sum = 0;
        
        for(int i = 0; i < a.length; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            list[u].add(v);
            list[v].add(u);
        }
        for(int i = 0; i<a.length; i++){
            sum += a[i];
            weights[i] = a[i];
        }
        
        // 완성 불가
        if(sum != 0){
            return -1;
        }
        
        dfs(0);
        return answer;
    }
    
    public static long dfs(int node){
        visited[node] = true;
        for(int i = 0; i < list[node].size(); i++){
            int next = list[node].get(i);
            if(visited[next]) continue;
            weights[node] += dfs(next);
        }
        answer += Math.abs(weights[node]);
        return weights[node];
    }
}