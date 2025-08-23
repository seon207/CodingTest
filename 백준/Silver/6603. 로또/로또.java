import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            arr = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            find(0, 0);
            System.out.println();
        }
    }

    public static void find(int depth, int idx) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                find(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}