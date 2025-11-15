import java.io.*;
import java.util.*;

class Solution {
    static int[] parents;
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        int answer = 0;
        
        for(int i = 0; i<n; i++){
            parents[i] = i; // 자기 자신이 부모
        }
        
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);  // 오름차순 정렬
        
        for(int i = 0; i < costs.length; i++){
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];
            
            if(union(start, end)){
                answer += cost;
            }
        }
        return answer;
    }
    
    public static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) return false;
        
        parents[rootB] = rootA;
        return true;
    }
    
    public static int find(int a){
        if(parents[a] == a){
            return a;
        }
        
        return parents[a] = find(parents[a]);
    }
}