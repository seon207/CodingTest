import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max, total;
    static int[] books;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();

        books = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, Math.abs(books[i]));    // 가장 멀리 있는 책
        }

        Arrays.sort(books);

        // 음수
        int idx = 0;
        while (idx < N && books[idx] < 0) {
            queue.add(Math.abs(books[idx]));
            idx += M;
        }

        idx = N - 1;

        // 양수
        while (idx >= 0 && books[idx] > 0) {
            queue.add(books[idx]);
            idx -= M;
        }

        while (!queue.isEmpty()) {
            total += queue.poll() * 2;  // 왕복
        }

        System.out.println(total - max);

    }
}