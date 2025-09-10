// BOJ_1992 쿼드트리

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = "";

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        divide(0, 0, N);

        System.out.println(result);
    }

    public static void divide(int x, int y, int size) {
        if (check(x, y, size)) {   // 모두 같을 때 -> 하나로
            result += map[x][y];
            return;
        }

        // 압축 안될 때
        int nSize = size / 2;

        result += "(";

        divide(x, y, nSize);
        divide(x, y + nSize, nSize);
        divide(x + nSize, y, nSize);
        divide(x + nSize, y + nSize, nSize);
        result += ")";
    }

    public static boolean check(int x, int y, int size) {
        int cur = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (cur != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}