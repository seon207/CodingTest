import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> queue;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new ArrayDeque<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll();   // 맨 위에꺼 버리기
            int bottom = queue.poll();
            queue.offer(bottom);
        }

        System.out.println(queue.peek());
    }
}