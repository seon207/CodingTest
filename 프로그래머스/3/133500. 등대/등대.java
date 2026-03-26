import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer;
    public int solution(int n, int[][] lighthouse) {
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        answer = 0;
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] link : lighthouse){
            int s = link[0];
            int e = link[1];
            
            list[s].add(e);
            list[e].add(s);
        }
        
        lights(1,0);
        
        return answer;
    }
    
    public static int lights(int cur, int pre) {
        if (list[cur].size() == 1 && list[cur].get(0) == pre) {
            return 1;
        }

        int light = 0;

        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);

            if (next == pre) continue;

            light += lights(next, cur);
        }

        if (light == 0) {
            return 1;
        }

        answer++;
        return 0;
    }
}