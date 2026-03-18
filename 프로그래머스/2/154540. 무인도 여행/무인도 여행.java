import java.io.*;
import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Integer> survive;
    static int[][] map;
    static int N, M;
    public int[] solution(String[] maps) {
        survive = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        map = new int[N][M];
        
        for(int i = 0; i < N; i++){
            String s = maps[i];
            for(int j = 0; j < M; j++){
                if(s.charAt(j) == 'X'){
                    map[i][j] = -1;
                }else{
                    map[i][j] = s.charAt(j) - '0';
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] != -1){
                    int food = bfs(i,j);
                    survive.add(food);
                }
            }
        }
        
        int[] answer = {};
        Collections.sort(survive);
        if(survive.size() == 0){
            answer = new int[]{-1};
        }else{
            answer = survive.stream()
                             .mapToInt(i -> i)
                             .toArray();
        }
        
        return answer;
    }
    
    public static int bfs(int i, int j){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        int food = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            food += map[x][y];
            
            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || ny < 0 || nx >= N||ny >= M||visited[nx][ny] || map[nx][ny] == -1) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});         
            }
        }
        
        return food;
    }
}