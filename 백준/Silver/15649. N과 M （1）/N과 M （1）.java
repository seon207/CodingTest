import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        arr = new int[M];

        perm(0);
    }

    public static void perm(int depth) {
        if (depth == M) { // 전부 선택함
            StringBuilder sb = new StringBuilder();
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            arr[depth] = i;
            visited[i] = true;
            perm(depth + 1);
            visited[i] = false;
        }
    }
}