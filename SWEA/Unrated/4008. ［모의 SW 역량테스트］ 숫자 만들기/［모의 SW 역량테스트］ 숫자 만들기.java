import java.io.*;
import java.util.*;

public class Solution {
    static int min, max, N;
    static int[] order, calc, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            calc = new int[4];
            order = new int[N - 1];
            num = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                calc[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            perm(0);

            sb.append("#").append(tc).append(" ").append(max - min).append("\n");
        }

        System.out.println(sb);
    }

    public static void perm(int depth) {
        if (depth == N - 1) {
            calculate();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (calc[i] > 0) {
                calc[i]--;
                order[depth] = i;
                perm(depth + 1);
                calc[i]++;
            }
        }
    }

    public static void calculate() {
        int result = num[0]; // 처음
        for (int i = 1; i < N; i++) {
            if (order[i - 1] == 0) {
                result += num[i];
            } else if (order[i - 1] == 1) {
                result -= num[i];
            } else if (order[i - 1] == 2) {
                result *= num[i];
            } else if (order[i - 1] == 3) {
                result /= num[i];
            }
        }

        min = Math.min(result, min);
        max = Math.max(result, max);
    }
}