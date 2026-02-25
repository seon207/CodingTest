import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        for(int[] point: rectangle){
            int x1 = point[0] * 2;
            int y1 = point[1] * 2;
            int x2 = point[2] * 2;
            int y2 = point[3] * 2;
            
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    if(i > x1 && i < x2 && j > y1 && j < y2){
                        map[i][j] = 1;
                    }else if(map[i][j] != 1){
                        map[i][j]=2;
                    }
                }
            }
        }
        map[characterX*2][characterY*2] = 2;
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2);
    }
    
    public static int bfs(int cx, int cy, int ix, int iy){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        queue.offer(new int[]{cx, cy, 0});
        visited[cx][cy] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == ix && cur[1] == iy){
                return cur[2] / 2;
            }
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int d = cur[2];
                
                if(nx >=0 && nx<101 && ny >=0 && ny<101 && !visited[nx][ny] && map[nx][ny] == 2){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, d+1});
                }
            }
        }
        return 0;
    }
}