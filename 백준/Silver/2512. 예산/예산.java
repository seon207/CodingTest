import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N];
        int sum = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
            max = Math.max(max, cost[i]);
        }

        M = Integer.parseInt(br.readLine());

        if (sum <= M) {
            System.out.println(max);
            return;
        }
            int start = 1;
            while (start < max - 1) {
                int mid = (start + max) / 2;

                if (cal(mid) > M) { // 범위 줄임
                    max = mid;
                } else {
                    start = mid;    // 범위 늘림
                }
            }
        System.out.println(start);


    }

    public static int cal(int mid) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.min(cost[i], mid);  // 상한액과 예산요청 중 작은 값 더함
        }
        return sum;
    }
}