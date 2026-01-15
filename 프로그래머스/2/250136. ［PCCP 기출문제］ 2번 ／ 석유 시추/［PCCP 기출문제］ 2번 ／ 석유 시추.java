import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static int N,M;
    static boolean[][] visited;
    static int[] amount;
    static Set<Integer> set;
    public int solution(int[][] land) {
        N = land.length;    // 세로
        M = land[0].length; // 가로
        amount = new int[M];
        set = new HashSet<>();
        
        map = land.clone();
        visited = new boolean[N][M];
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[j][i] && map[j][i] == 1){
                    bfs(j,i);
                }
            }
        }
        
        int answer = 0;
        for(int a : amount){
            answer = Math.max(answer, a);
        }
        return answer;
    }
    
    public static void bfs(int i, int j){
        Queue<int[]> queue = new ArrayDeque<>();
        
        set = new HashSet<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        int mass = 1;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            set.add(cur[1]);    // 열 위치 저장
            
            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny});
                mass++;
            }
        }
        
        for(int s: set){
            amount[s] += mass;
        }
    }
}