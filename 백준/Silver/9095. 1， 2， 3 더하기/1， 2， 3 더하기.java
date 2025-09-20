import java.io.*;
import java.util.*;

public class Main {
    static int T, n, count;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        visited = new boolean[4];
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            count = 0;
            perm(0, 1);
            System.out.println(count);
        }
    }

    public static void perm(int sum, int idx) {
        if (sum == n) {
            count++;
            return;
        }

        if (sum > n) {
            return;
        }

        for (int i = idx; i <= 3; i++) {
            perm(sum + i, idx);
        }
    }


}