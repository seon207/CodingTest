import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int x1 = -1, y1 = -1;
        int x2 = -1, y2 = -1;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'o') {
                    if (x1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }

        System.out.println(bfs(x1, y1, x2, y2));
    }

    static int bfs(int x1, int y1, int x2, int y2) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x1, y1, x2, y2, 0});
        visited[x1][y1][x2][y2] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int cx1 = cur[0];
            int cy1 = cur[1];
            int cx2 = cur[2];
            int cy2 = cur[3];
            int cnt = cur[4];

            if (cnt >= 10) continue;

            for (int d = 0; d < 4; d++) {
                int nx1 = cx1 + dx[d];
                int ny1 = cy1 + dy[d];
                int nx2 = cx2 + dx[d];
                int ny2 = cy2 + dy[d];

                boolean out1 = isOut(nx1, ny1);
                boolean out2 = isOut(nx2, ny2);

                if (out1 && out2) continue;

                if (out1 ^ out2) return cnt + 1;

                if (map[nx1][ny1] == '#') {
                    nx1 = cx1;
                    ny1 = cy1;
                }
                if (map[nx2][ny2] == '#') {
                    nx2 = cx2;
                    ny2 = cy2;
                }

                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    queue.offer(new int[]{nx1, ny1, nx2, ny2, cnt + 1});
                }
            }
        }

        return -1;
    }

    static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}