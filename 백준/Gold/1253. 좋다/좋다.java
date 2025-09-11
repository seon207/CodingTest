import java.io.*;
import java.util.*;

public class Main {
    static int N, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);


        search();

        System.out.println(count);
    }

    public static void search() {
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            while (true) {

                if (left == i) left++;
                if (right == i) right--;

                //  같으면 합으로 표현할 수 없음
                if (left >= right) break;

                // 작으면 left + 1, 크면 right - 1
                if (arr[right] + arr[left] < arr[i]) {
                    left++;
                } else if (arr[right] + arr[left] > arr[i]) {
                    right--;
                } else {    // 좋은 수
                    count++;
                    break;
                }
            }
        }
    }
}