import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static long max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        max = Long.MIN_VALUE;

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        long start = 0;
        long end = max + 1;
        long mid = 0;
        int count = 0;

        while (start < end) {
            mid = (start + end) / 2;
            count = 0;

            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            if (count < N) {    // 더 줄이기
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start - 1);

    }
}