import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr1, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr1 = new int[N];
        arr2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int result = 0;

        for (int i = 0; i < N; i++) {
            result += arr2[N - i - 1] * arr1[i];
        }

        System.out.println(result);

    }
}