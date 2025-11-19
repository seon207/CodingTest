import java.io.*;
import java.util.*;

public class Main {
    static int N, K, max;
    static int[] arr, sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        sums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sums[i] = sums[i - 1] + arr[i];
        }

        max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            int val = sums[i] - sums[i - K];
            max = Math.max(val, max);
        }


        System.out.println(max);
    }
}