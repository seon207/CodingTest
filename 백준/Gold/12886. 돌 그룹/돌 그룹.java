import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B, C) ? 1 : 0);
    }

    public static boolean bfs(int a, int b, int c) {

        if ((a + b + c) % 3 != 0) return false; // 세 그룹의 합이 3으로 안나눠지면 불가능

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[1501][1501];

        queue.add(new int[]{a, b, c});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] group = queue.poll();

            int ga = group[0];
            int gb = group[1];
            int gc = group[2];

            if (ga == gb && gb == gc) { // 모두 같아졌을 때
                return true;
            }

            if (ga != gb) {
                int na = ga > gb ? ga - gb : ga + ga;
                int nb = ga > gb ? gb + gb : gb - ga;

                if (!visited[na][nb]) { // 방문하지 않은 곳일 때
                    queue.add(new int[]{na, nb, gc});
                    visited[na][nb] = true;
                }
            }

            if (gb != gc) {
                int nb = gb > gc ? gb - gc : gb + gb;
                int nc = gb > gc ? gc + gc : gc - gb;

                if (!visited[nb][nc]) {
                    queue.add(new int[]{ga, nb, nc});
                    visited[nb][nc] = true;
                }
            }

            if (ga != gc) {
                int na = ga > gc ? ga - gc : ga + ga;
                int nc = ga > gc ? gc + gc : gc - ga;

                if (!visited[na][nc]) {
                    queue.add(new int[]{na, gb, nc});
                    visited[na][nc] = true;
                }
            }
        }

        return false;
    }
}
