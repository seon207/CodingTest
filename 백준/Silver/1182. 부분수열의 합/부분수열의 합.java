import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, count;
    static int[] list;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        list = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];

        dfs(0, 0);

        if (S == 0) {
            count--;
        }
        System.out.println(count);
    }

    public static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(depth + 1, sum + list[depth]);  // 선택
        dfs(depth + 1, sum);    // 선택 x
    }
}