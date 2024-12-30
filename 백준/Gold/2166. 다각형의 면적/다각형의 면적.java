import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        info[N][0] = info[0][0];
        info[N][1] = info[0][1];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (long) info[i][0] * info[i + 1][1] - (long) info[i][1] * info[i + 1][0];
        }

        System.out.printf("%.1f" , (Math.abs(sum)/2.0));
    }
}
