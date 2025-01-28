import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, count;
    static int[] map;   // index = 열, 값 = 행

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        backtracking(0);
        System.out.println(count);
    }

    public static void backtracking(int queen) {
        if (queen == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            map[queen] = i;
            if (check(queen)) {   // 놓을 수 있을 때
                backtracking(queen + 1);
            }
        }
    }

    public static boolean check(int col) {
        for (int i = 0; i < col; i++) { // 같은 행
            if (map[col] == map[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(map[col] - map[i])) { //대각선에 있을 때
                return false;
            }
        }
        return true;
    }
}
