import java.io.*;
import java.util.*;

public class Solution {
    static int N, L;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N + 1][2];
            dp = new int[N + 1][L + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= L; j++) {
                    int kcal = arr[i][1];
                    int score = arr[i][0];
                    if (kcal > j) {    // 칼로리가 크면 선택 x
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - kcal] + score);
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(dp[N][L]).append("\n");

        }

        System.out.println(sb);
    }
}