import java.io.*;
import java.util.*;

public class Main {
    static int N, min;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    divide(i, j, num++);
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    visited = new boolean[N][N];
                    path(i, j, map[i][j]);
                }
            }
        }

        System.out.println(min);
    }

    public static void path(int i, int j, int num) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new int[]{i, j, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dis = cur[2];

            // 다른 섬에 도달함
            if (map[x][y] != 0 && map[x][y] != num) {
                min = Math.min(min, dis - 1);
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                // 같은 섬
                if (map[nx][ny] == num) {
                    queue.offer(new int[]{nx, ny, dis});
                    visited[nx][ny] = true;
                } else if(map[nx][ny] != num) {
                    queue.offer(new int[]{nx, ny, dis + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void divide(int i, int j, int num) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        map[i][j] = num;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] != 1) continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                map[nx][ny] = num;
            }
        }
    }
}