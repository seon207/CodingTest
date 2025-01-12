import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static long[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new long[V + 1][V + 1];
        for (int i = 1; i < V + 1; i++) {
            Arrays.fill(map[i], 4_000_001);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], c);
        }

        for (int k = 1; k < V + 1; k++) {   // 경유점
            for (int i = 1; i < V + 1; i++) {   // 시작점
                for (int j = 1; j < V + 1; j++) {   // 도착점
                    if (map[i][j] > map[i][k] + map[k][j]) {    // 더 작은 거리를 발견했을 경우 업데이트
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        long result = 4_000_001;
        for (int i = 1; i < V + 1; i++) {
            result = Math.min(result, map[i][i]);
        }

        System.out.println(result == 4_000_001 ? -1 : result);
    }
}