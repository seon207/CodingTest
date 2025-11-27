import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[] ground, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ground = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ground[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dirt = Integer.parseInt(st.nextToken());

            dp[start - 1] += dirt;
            if (end < N) {
                dp[end] += -dirt;
            }
        }

        int add = 0;
        for (int i = 0; i < N; i++) {
            add += dp[i];
            sb.append(add + ground[i]).append(" ");
        }

        System.out.println(sb);

    }
}