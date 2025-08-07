//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static int N, M, max;
//    static char[][] map;
//    static int[][] visited; // 방문(거리로 계산)
//    static int[] dx = {0, 1, 0, -1};
//    static int[] dy = {1, 0, -1, 0};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        map = new char[N][M];
//        // 입력
//        for (int i = 0; i < N; i++) {
//            String s = br.readLine();
//            for (int j = 0; j < M; j++) {
//                map[i][j] = s.charAt(j);
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (map[i][j] == 'L') { // 땅일 때
//                    visited = new int[N][M];
//                    bfs(i, j);
//                }
//            }
//        }
//
//        System.out.println(max);
//
//    }
//
//    public static void bfs(int x, int y) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{x, y});
//        visited[x][y] = 1;
//
//        while (!queue.isEmpty()) {
//            int[] now = queue.poll();
//            int cx = now[0];
//            int cy = now[1];
//
//            for (int i = 0; i < 4; i++) {
//                int nx = cx + dx[i];
//                int ny = cy + dy[i];
//
//                // 범위 벗어나거나 물이면 패스
//                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny] != 0 || map[nx][ny] == 'W') {
//                    continue;
//                }
//                queue.offer(new int[]{nx, ny});
//                visited[nx][ny] = visited[cx][cy] + 1;  // 거리 + 1
//                if (visited[nx][ny] - 1 > max)  // 더 큰 값일 때
//                    max = visited[nx][ny] - 1;
//            }
//        }
//    }
//}

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static int N, M, count;
//    static int[][] map;
//    static boolean[][] visited;
//
//    // 상하좌우 대각선
//    static int[] dx = {0, 1, 0, -1, 1, -1, -1, 1};
//    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        map = new int[N][M];
//        visited = new boolean[N][M];
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                // 방문 안했고 1인 경우에만 시작
//                if (!visited[i][j] && map[i][j] == 1) {
//                    bfs(i, j);
//                    count += 1;
//                }
//            }
//        }
//
//        System.out.println(count);
//
//    }
//
//    public static void bfs(int x, int y) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{x, y});
//        visited[x][y] = true;
//
//        while (!queue.isEmpty()) {
//            int[] now = queue.poll();
//            int cx = now[0];
//            int cy = now[1];
//
//            for (int i = 0; i < 8; i++) {
//                int nx = cx + dx[i];
//                int ny = cy + dy[i];
//
//                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || visited[nx][ny] || map[nx][ny] == 0)
//                    continue;
//                visited[nx][ny] = true;
//                queue.offer(new int[]{nx, ny});
//            }
//        }
//    }
//}

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, count;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1, 1, -1, -1, 1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}