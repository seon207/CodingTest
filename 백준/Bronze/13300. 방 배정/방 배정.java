import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[6][2];    // 학년, 성별
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            arr[grade - 1][gender]++;
        }

        int rooms = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] != 0) {
                    rooms += arr[i][j] / K;  // 최대 수용인원
                    if (arr[i][j] % K != 0) {
                        rooms++;
                    }
                }
            }
        }
        System.out.println(rooms);
    }
}
