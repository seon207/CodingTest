import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        // 큰거 : 2, 작은거 1
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());

            map[big][small] = 2;
            map[small][big] = 1;
        }

        for (int k = 1; k <= N; k++) {  // 거쳐감
            for (int i = 1; i <= N; i++) {  // 시작
                for (int j = 1; j <= N; j++) {  // 끝
                    if (map[i][k] != 0 && map[i][k] == map[k][j]) {
                        map[i][j] = map[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int max = 0;
            int min = 0;

            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    max++;
                }

                if (map[j][i] == 1) {
                    min++;
                }
            }

            if (max >= (N + 1) / 2 || min >= (N + 1) / 2) {
                result++;
            }
        }
        System.out.println(result);

    }
}