import java.io.*;
import java.util.*;

public class Main {
    static int N, M, diff;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        diff = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        search();

        System.out.println(diff);
    }

    public static void search() {
        int left = 0;
        int right = 0;

        while (right < N) {
            // M보다 작을 때 -> right + 1
            if (arr[right] - arr[left] < M) {
                right++;
            } else if (arr[right] - arr[left] == M) {
                diff = M;
                break;
            } else {    // M보다 클 때
                diff = Math.min(arr[right] - arr[left], diff);
                left++;
            }
        }
    }
}