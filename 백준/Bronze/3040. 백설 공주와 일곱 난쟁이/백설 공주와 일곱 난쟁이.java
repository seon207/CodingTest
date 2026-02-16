import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        nums = new int[9];
        visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        find(0, 0, 0);
    }

    public static void find(int depth, int sum, int start) {
        if (depth == 7) {
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(arr[i]);
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                find(depth + 1, sum + arr[depth], i + 1);
                visited[i] = false;
            }
        }
    }
}