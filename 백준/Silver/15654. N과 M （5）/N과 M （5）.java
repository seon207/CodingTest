import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] num;
    static int[] list;
    static StringBuilder sb;
    static boolean[] is_possible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        list = new int[M];
        is_possible = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        comb(0);

        System.out.println(sb);
    }

    public static void comb(int depth) {
        if (depth == M) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!is_possible[i]) {
                is_possible[i] = true;
                list[depth] = num[i];
                comb(depth + 1);
                is_possible[i] = false;
            }
        }
    }
}