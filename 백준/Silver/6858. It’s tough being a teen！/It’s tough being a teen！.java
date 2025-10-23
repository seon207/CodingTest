import java.io.*;
import java.util.*;

public class Main {
    static int[] indegrees = new int[8];
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            list.add(new ArrayList<>());
        }
        // 초기 상태
        add(1, 7);
        add(1, 4);
        add(2, 1);
        add(3, 4);
        add(3, 5);
        while (true) {
            int first = Integer.parseInt(br.readLine());
            int second = Integer.parseInt(br.readLine());

            if (first == 0 && second == 0) {
                break;
            }

            add(first, second);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);

            for (int next : list.get(cur)) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (result.size() < 7) {
            System.out.println("Cannot complete these tasks. Going to bed.");
        } else {
            for (int i : result) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void add(int a, int b) {
        list.get(a).add(b);
        indegrees[b]++;
    }
}