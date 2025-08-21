import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        flag = false;
        make(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 스토쿠 만들기
    public static void make(int depth) {
        if (depth == 81) {  // 다 채움

            flag = true;
            return;
        }

        // 채우기
        int row = depth / 9;
        int col = depth % 9;

        // 이미 채워져 있을 때
        if (map[row][col] != 0) {
            make(depth + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {   // 확인
                    map[row][col] = i;
                    make(depth + 1);
                    if (flag) { // 이미 스토쿠 완성했을 때
                        return;
                    }
                    map[row][col] = 0;
                }
            }
        }
    }

    public static boolean check(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {   // 행, 열 확인
            if (map[row][i] == num || map[i][col] == num) return false;
        }

        // 3*3 확인
        int nr = row / 3 * 3;
        int nc = col - col % 3;

        for (int i = nr; i < nr + 3; i++) {
            for (int j = nc; j < nc + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}