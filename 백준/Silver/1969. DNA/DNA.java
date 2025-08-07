import java.util.*;
import java.io.*;

public class Main {
    static int N, M, count;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                switch (c) {
                    case 'A':
                        arr[i][j] = 0;
                        break;

                    case 'C':
                        arr[i][j] = 1;
                        break;

                    case 'G':
                        arr[i][j] = 2;
                        break;

                    case 'T':
                        arr[i][j] = 3;
                        break;
                }
            }
        }

        StringBuilder s = new StringBuilder();
        for (int j = 0; j < M; j++) {
            char[] alphabets = new char[4];
            for (int i = 0; i < N; i++) {
                alphabets[arr[i][j]]++;
            }
            int total = 0;
            int max_idx = 0;
            for (int k = 0; k < 4; k++) {
                if (total < alphabets[k]) {
                    total = alphabets[k];
                    max_idx = k;
                }
            }

            switch (max_idx) {
                case 0:
                    s.append("A");
                    break;
                case 1:
                    s.append("C");
                    break;
                case 2:
                    s.append("G");
                    break;
                case 3:
                    s.append("T");
                    break;
            }

            count += N - total;

        }

        System.out.println(s);
        System.out.println(count);
    }
}