import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    public static int move() {
        int result = 0;

        while (true) {
            boolean isMoved = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {   // 국경 안열림
                        int sum = dfs(i, j);
                        if (list.size() > 1) {
                            cal(sum);
                            isMoved = true;
                        }
                    }
                }
            }
            if (!isMoved) return result;
            result++;
        }
    }

    public static int dfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        list = new ArrayList<>();
        queue.add(new int[]{i, j});
        list.add(new int[]{i, j});
        visited[i][j] = true;

        int sum = map[i][j];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int n = 0; n < 4; n++) {
                int nx = current[0] + dx[n];
                int ny = current[1] + dy[n];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (Math.abs(map[current[0]][current[1]] - map[nx][ny]) >= L && Math.abs(map[current[0]][current[1]] - map[nx][ny]) <= R) {
                        queue.add(new int[]{nx, ny});
                        list.add(new int[]{nx, ny});
                        sum += map[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return sum;
    }

    public static void cal(int sum) {
        int avg = sum / list.size();
        for (int[] n : list) {
            map[n[0]][n[1]] = avg;
        }
    }
}