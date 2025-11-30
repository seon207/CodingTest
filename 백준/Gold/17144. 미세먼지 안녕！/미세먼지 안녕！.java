import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map, spread;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static ArrayList<int[]> loc;    // 공기청정기 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        loc = new ArrayList<>();

        map = new int[R][C];

        // 입력
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    loc.add(new int[]{i, j});
                }
            }
        }

        for (int time = 0; time < T; time++) {
            // 미세먼지 확산
            spread();

            // 공기청정기 가동
            operate();
        }

        int dust = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0 && map[i][j] != -1) {
                    dust += map[i][j];
                }
            }
        }

        System.out.println(dust);

    }

    public static void spread() {
        spread = new int[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != -1 && map[i][j] != 0) {  // 확산할 수 있을 때
                    int remove = count(i, j);
                    spread[i][j] += map[i][j] - (Math.abs(map[i][j] / 5) * remove);    // 현재 위치 미세먼지 업데이트
                }
            }
        }

        map = spread;
    }

    // 미세먼지 확산 개수
    public static int count(int i, int j) {
        int minus = Math.abs(map[i][j] / 5);
        int c = 0;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (map[nx][ny] != -1) {    // 확산된 방향의 개수
                spread[nx][ny] += minus;   // 주변 미세먼지 추가
                c++;
            }
        }
        return c;
    }

    // 공기청정기 가동
    public static void operate() {
        int top = loc.get(0)[0];
        int bottom = loc.get(1)[0];

        // 위
        for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i - 1];
        map[top][1] = 0;

        // 아래
        for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
        map[bottom][1] = 0;

        map[top][0] = -1;
        map[bottom][0] = -1;

    }
}