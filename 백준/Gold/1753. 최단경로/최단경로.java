import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<Node>[] list;
    static int[] distance;
    static int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        list = new ArrayList[V + 1];

        Arrays.fill(distance, INF);

        for (int i = 0; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w));
        }

        dij(K);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (distance[i] != INF) {
                sb.append(distance[i]).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void dij(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        q.add(new Node(start, 0));
        distance[start] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int s = cur.end;
            if (visited[s]) continue;

            visited[s] = true;

            for (Node node : list[s]) {
                if (distance[node.end] > distance[s] + node.weight) {
                    distance[node.end] = distance[s] + node.weight;
                    q.add(new Node(node.end, distance[node.end]));
                }
            }
        }
    }
}