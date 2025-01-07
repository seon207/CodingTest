import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (isPalindrome(start, end)) sb.append(1).append("\n");
            else sb.append(0).append("\n");

        }

        System.out.println(sb);
    }

    public static boolean isPalindrome(int start, int end) {
        if (start == end) return true;
        for (int i = 0; i <= end - start; i++) {
            if (arr[start + i] != arr[end - i]) return false;
        }
        return true;
    }
}