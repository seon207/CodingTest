import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] num;   // 가능 여부 확인
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new boolean[N + 1];
        list = new int[M];
        perm(0, 0);
    }

    public static void perm(int depth, int idx) {
        if (depth == M) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!num[i]) {
                num[i] = true;
                list[idx] = i;
                perm(depth + 1, idx + 1);
                num[i] = false;
            }
        }

    }
}