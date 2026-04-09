import java.io.*;
import java.util.*;

public class Main {
    static int computers, networks, count;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computers = Integer.parseInt(br.readLine());
        networks = Integer.parseInt(br.readLine());
        list = new ArrayList[computers + 1];
        visited = new boolean[computers + 1];

        for (int i = 1; i <= computers; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < networks; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[e].add(s);
            list[s].add(e);
        }

        worm();
        System.out.println(count);
    }

    static void worm() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); // 1부터 감염
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int coms : list[cur]) {
                if (!visited[coms]) {   // 새롭게 감염
                    queue.offer(coms);
                    count++;
                    visited[coms] = true;
                }
            }
        }
    }
}