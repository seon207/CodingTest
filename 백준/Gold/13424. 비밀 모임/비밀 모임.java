import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T, K;
    static int[][] dist;
    static int[] result;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dist = new int[N + 1][N + 1];
            result = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                dist[s][e] = w;
                dist[e][s] = w;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    if (dist[i][k] == INF) continue;
                    for (int j = 1; j <= N; j++) {
                        if (dist[k][j] == INF) continue;
                        int via = dist[i][k] + dist[k][j];
                        if (via < dist[i][j]) dist[i][j] = via;
                    }
                }
            }

            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            // 현재 친구 위치
            for (int k = 0; k < K; k++) {
                int cur = Integer.parseInt(st.nextToken());

                for (int l = 1; l <= N; l++) {
                    result[l] += dist[cur][l];
                }
            }
            int distance = INF;
            int room = 1;
            for (int i = 1; i <= N; i++) {
                if (result[i] < distance) {
                    distance = result[i];
                    room = i;
                }
            }

            sb.append(room).append('\n');
        }

        System.out.print(sb);
    }
}