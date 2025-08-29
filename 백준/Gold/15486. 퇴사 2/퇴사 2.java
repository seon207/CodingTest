import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] T, P, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 1];

        // 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < N; i++) {
            if (i + T[i] <= N) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[N]);
    }
}