import java.io.*;
import java.util.*;

public class Main {
    static int N, B, C;
    static int[] arr;
    static long total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        total += N;
        for (int i = 0; i < N; i++) {
            arr[i] -= B;
            if (arr[i] <= 0) continue;
            total += arr[i] / C;
            if (arr[i] % C != 0) {
                total++;
            }
        }

        System.out.println(total);
    }
}