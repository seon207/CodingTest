import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 연병장 크기
        int M = Integer.parseInt(st.nextToken());   // 조교의 수

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        int[] sums = new int[N + 2];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {    //커멘드
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 처음과 끝만 계산해서 누적합으로 처리
            sums[a] += k;
            sums[b + 1] -= k;
        }

        for (int i = 1; i < N + 1; i++) {   // 누적합 계산
            sums[i] = sums[i - 1] + sums[i];
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.print(arr[i] + sums[i] + " ");
        }
    }
}
