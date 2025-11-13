import java.io.*;
import java.util.*;

class Solution {
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Integer>[] arrayList;
    public int solution(int n, int[][] edge) {
        arrayList = new ArrayList[n + 1];
        visited = new boolean[n+1];
        distance = new int[n+1];
        
        for(int i = 1; i < n + 1; i++){
         arrayList[i] = new ArrayList<>();   
        }
        
        for(int i = 0; i < edge.length; i++){
            int s = edge[i][0];
            int e = edge[i][1];
            
            arrayList[s].add(e);
            arrayList[e].add(s);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;
        visited[1] = true;
        
        int max = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next : arrayList[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    distance[next] = distance[cur] + 1;
                    max = distance[next];
                }
            }
        }
        
        
        int answer = 0;
        for(int i = 1; i < n + 1; i++){
            if(distance[i] == max){
                answer++;
            }
        }
        
        return answer;
    }
}