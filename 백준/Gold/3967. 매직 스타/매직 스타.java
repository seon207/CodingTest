import java.io.*;
import java.util.*;

public class Main {
    static char[][] star;
    static boolean[] alphabets;

    static ArrayList<int[]> arrayList;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        star = new char[5][9];
        alphabets = new boolean[12];
        arrayList = new ArrayList<>();
        flag = false;

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                char c = s.charAt(j);
                star[i][j] = c;
                if (c == 'x') {
                    arrayList.add(new int[]{i, j});
                }
                if (c >= 'A' && c <= 'Z') {
                    alphabets[c - 'A'] = true; // 이미 사용한 숫자
                }
            }
        }

        find(0);

    }

    public static void find(int depth) {
        if (depth == arrayList.size()) {
            if (check()) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(star[i][j]);
                    }
                    System.out.println();
                }
                flag = true;
            }
            return;
        }

        if (flag) {
            return;
        }

        for (int i = 0; i < 12; i++) {  // L까지 확인
            if (!alphabets[i]) {
                int[] cur = arrayList.get(depth);
                star[cur[0]][cur[1]] = (char) (i + 65);
                alphabets[i] = true;
                find(depth + 1);
                alphabets[i] = false;
                star[cur[0]][cur[1]] = 'x';
            }
        }

    }

    // 구간 확인
    public static boolean check() {
        return (star[0][4] - 'A' + 1 + star[1][3] - 'A' + 1 + star[2][2] - 'A' + 1 + star[3][1] - 'A' + 1 == 26) && (star[0][4] - 'A' + 1 + star[1][5] - 'A' + 1 + star[2][6] - 'A' + 1 + star[3][7] - 'A' + 1 == 26) && (star[3][1] - 'A' + 1 + star[3][3] - 'A' + 1 + star[3][5] - 'A' + 1 + star[3][7] - 'A' + 1 == 26) && (star[1][1] - 'A' + 1 + star[1][3] - 'A' + 1 + star[1][5] - 'A' + 1 + star[1][7] - 'A' + 1 == 26) && (star[1][1] - 'A' + 1 + star[2][2] - 'A' + 1 + star[3][3] - 'A' + 1 + star[4][4] - 'A' + 1 == 26) && (star[1][7] - 'A' + 1 + star[2][6] - 'A' + 1 + star[3][5] - 'A' + 1 + star[4][4] - 'A' + 1 == 26);
    }
}