import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map, result;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static class Node implements Comparable<Node> {
        int x, y, w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dij();
        System.out.println(result[n - 1][n - 1]);
    }

    public static void dij() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int[] results : result) {
            Arrays.fill(results, Integer.MAX_VALUE);
        }

        result[0][0] = 0;
        pq.offer(new Node(0, 0, result[0][0]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (result[node.x][node.y] < node.w) continue;

            for (int i = 0; i < 2; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int w = map[nx][ny] - map[node.x][node.y] + 1;
                    if (w <= 0) w = 0;

                    if (result[nx][ny] > node.w + w) {
                        result[nx][ny] = node.w + w;
                        pq.offer(new Node(nx, ny, result[nx][ny]));
                    }
                }
            }
        }
    }
}
