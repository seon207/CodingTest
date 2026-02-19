import java.util.*;
import java.io.*;

class Solution {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0, 0, 1}); 
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m
                        && !visited[nx][ny] && maps[nx][ny] == 1) {

                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }
}