import java.io.*;
import java.util.*;

class Solution {
    static int[] extand;
    static int answer;
    static int[] turn;
    static boolean[] visited;
    static int W;
    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        extand = new int[weak.length * 2];
        turn = new int[dist.length];
        visited = new boolean[dist.length];
        W = weak.length;
        for(int i = 0; i < weak.length; i++){
            extand[i] = weak[i];
        }
        for(int i = weak.length; i < extand.length; i++){
            extand[i] = weak[i-weak.length] + n;
        }
        
        perm(dist, 0);
        return answer == Integer.MAX_VALUE? -1:answer;
    }
    
    public static void perm(int[] dist, int depth){
        if(answer == 1) return;
        if(depth == dist.length){   // 순열 다 만듦
            check();
            return;
        }
        
        for(int i = 0; i < dist.length; i++){
            if(!visited[i]){
                visited[i] = true;
                turn[depth] = dist[i];
                perm(dist, depth+1);
                visited[i] = false;
            }
        }
    }
    
    public static void check(){
        for(int i = 0; i < W; i++){
            boolean flag = true;
            int ppl = 1;    // 1명부터 시작
            int area = extand[i] + turn[0]; // 확인할 수 있는 지점
            
            for(int j = i; j < i + W; j++){
                if(extand[j] > area){   // 확인할 수 있는 지점 넘어섰을 때
                    ppl++;
                    if(ppl > turn.length) {
                        flag = false;
                        break;
                    }
                    area = extand[j] + turn[ppl-1];
                }
            }
            if(flag) answer = Math.min(ppl, answer);
        }
    }
}