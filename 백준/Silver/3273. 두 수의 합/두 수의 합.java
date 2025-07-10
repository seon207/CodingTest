import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] a = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        int x = Integer.parseInt(br.readLine());
        int i = 0; // 맨 앞에서부터 시작
        int j = n - 1; // 맨 뒤에서부터 시작
        Arrays.sort(arr);

        int result = 0;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == x) { // 정답이면 result + 1
                result++;
                i++;
                j--;
            } else if (sum < x) {   // 목표보다 작을 때
                i++;
            } else {  // 목표보다 클 때
                j--;
            }
        }
        System.out.println(result);
    }
}
