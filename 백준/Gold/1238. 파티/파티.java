import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<Node>[] list, bList;

    public static class Node implements Comparable<Node> {
        int e;
        int c;

        public Node(int e, int c) {
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        bList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            bList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
            bList[end].add(new Node(start, cost));
        }

        int[] dis = dij(new int[N + 1], new boolean[N + 1], list);
        int[] bDis = dij(new int[N + 1], new boolean[N + 1], bList);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int sum = dis[i] + bDis[i];
            if (sum > max) max = sum;
        }
        System.out.println(max);
    }

    public static int[] dij(int[] distance, boolean[] visited, ArrayList<Node>[] list) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;    // 출발 지점

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int now = n.e;

            if (visited[now]) continue;
            visited[now] = true;

            for (Node next : list[now]) {
                if (distance[next.e] > distance[now] + next.c) {
                    distance[next.e] = distance[now] + next.c;

                    pq.offer(new Node(next.e, distance[next.e]));
                }
            }
        }

        return distance;
    }
}