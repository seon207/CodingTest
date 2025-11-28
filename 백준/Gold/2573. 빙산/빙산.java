import java.io.*;
import java.util.*;

public class Main {
    static int N, M, total, time, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    total++;    // 총 빙하 개수
                }
            }
        }


        while (true) {

            // 빙하 덩어리 확인
            visited = new boolean[N][M];
            int left = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        find(i, j);  // 섬의 개수
                        left++;
                    }
                }
            }

            if (left >= 2) {
                break;
            }

            // 빙하 녹이기
            melt();
            if (total == 0) {
                break;
            }
            time++;
        }

        if (total == 0) {
            System.out.println(0);
        } else {
            System.out.println(time);
        }
    }


    public static void melt() {
        boolean[][] melted = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!melted[i][j] && map[i][j] != 0) {  // 녹을 수 있을 때
                    melted[i][j] = true;
                    int melt = 0;
                    // 주변 확인
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (map[nx][ny] == 0 && !melted[nx][ny]) {
                            melt++;
                        }
                    }
                    map[i][j] = Math.max(map[i][j] - melt, 0);
                    // 총 빙하 수 줄이기
                    if (map[i][j] == 0) {
                        total--;
                    }
                }
            }
        }
    }


    public static void find(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (!visited[nx][ny] && map[nx][ny] != 0) { // 연결된 상태일 때
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}


