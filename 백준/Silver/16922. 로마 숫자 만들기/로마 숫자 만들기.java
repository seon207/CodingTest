import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

// BOJ_16922 로마 숫자 만들기
public class Main {
    static int N;
    static int[] numbers;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[9999];
        numbers = new int[]{1, 5, 10, 50};
        perm(0, 0, 0);
        System.out.println(result);
    }

    public static void perm(int depth, int sum, int idx) {
        if (depth == N) {
            if (!visited[sum]) {
                result++;
                visited[sum] = true;
            }
            return;
        }

        for (int i = idx; i < 4; i++) {
            perm(depth + 1, sum + numbers[i], i);
        }

    }
}
