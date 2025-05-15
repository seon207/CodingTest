import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        int tc = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            map = new int[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<N; i++){
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dij();
            System.out.println("Problem " + tc + ": " + dist[N - 1][N - 1]);
            tc++;
        }
    }

    public static void dij() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N][N];
        visited[0][0] = true;
        dist[0][0] = map[0][0]; // 초기값
        pq.add(new Node(0, 0, dist[0][0]));
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int x = n.x;
            int y = n.y;
            int w = n.weight;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int distance = w + map[nx][ny];
                    visited[nx][ny] = true;
                    if (dist[nx][ny] > distance) {    // 업데이트
                        dist[nx][ny] = distance;
                    }
                    pq.add(new Node(nx, ny, dist[nx][ny]));
                }
            }
        }
    }
}