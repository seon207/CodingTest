import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Info {
        int start;
        int end;
        int weight;

        public Info(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int N, M;
    static long[] distance;
    static Info[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new long[N + 1];
        list = new Info[M + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[i] = new Info(start, end, weight);
        }

        distance[1] = 0;    // 시작 도시
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Info info = list[j];
                if (distance[info.start] + info.weight < distance[info.end] && distance[info.start] != Long.MAX_VALUE) {
                    distance[info.end] = distance[info.start] + info.weight;
                }
            }
        }

        // 음수 사이클 발생 확인
        boolean isCycle = false;    
        for (int i = 0; i < M; i++) {
            Info info = list[i];
            if (distance[info.start] + info.weight < distance[info.end] && distance[info.start] != Long.MAX_VALUE) {
                isCycle = true;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isCycle) {
            sb.append("-1");
        } else {
            for (int i = 2; i < N + 1; i++) {
                if (distance[i] == Long.MAX_VALUE) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(distance[i]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}