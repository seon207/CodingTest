import java.io.*;
import java.util.*;

public class Main {
    static int N, M, min;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        min = 64;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == 'W') {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                min = Math.min(find(i, j), min);
            }
        }
        System.out.println(min);
    }

    public static int find(int x, int y) {
        int count = 0;
        boolean first = map[x][y];  // 첫번째 칸
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (map[i][j] != first) {
                    count++;
                }
                first = !first;
            }
            first = !first;
        }
        return Math.min(count, 64 - count);
    }
}