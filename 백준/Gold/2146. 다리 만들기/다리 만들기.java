import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] map;
    private static int[][] check;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new int[N][N];
        visited = new boolean[N][N];
        result = Integer.MAX_VALUE;
        // 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visited[i][j] && check[i][j] == 0) {
                    check[i][j] = cnt;
                    bfs(i, j, cnt);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && check[i][j] != 0) { // 섬일 때
                    visited = new boolean[N][N];    // 방문 초기화
                    bfs(i, j, check[i][j], 0);  // bfs 시작
                }
            }
        }
        System.out.println(result);
    }

    public static void bfs(int a, int b, int cnt) {   // 연결된 섬끼리 같은 번호로 묶기
        Queue<int[]> queue = new LinkedList<>();
        visited[a][b] = true;
        queue.add(new int[]{a, b});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] != 0) { // 범위 안이고 방문 안했고, 바다 아닐 때
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    check[nx][ny] = cnt;
                }
            }
        }
    }

    public static void bfs(int x, int y, int c, int dist) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,c,dist});
        visited[x][y] = true;   // 방문 처리
        while(!q.isEmpty()){
            int[] cur = q.poll();

            int cx = cur[0];
            int cy = cur[1];
            int cc = cur[2];    // 같은 섬인지 확인
            int cd = cur[3];    // 거리 확인

            if(check[cx][cy] != cc && check[cx][cy] != 0){    // 다른 섬에 도착했을 때 + 바다 아닐 때
                result = Math.min(result, cd-1);  //  더 짧은 거리 갱신
            }

            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]){ // 범위 안이고 방문 안했을 때
                    if(check[nx][ny] == cc){    // 같은 섬일 때
                        q.add(new int[]{nx,ny,cc, cd}); // 섬의 가장자리부터 시작해야 하기 때문에 cd 그대로
                        visited[nx][ny] = true;
                    }
                    if(check[nx][ny] != cc) {   // 같은 섬이 아닐 때만 넣기
                        q.add(new int[]{nx, ny, cc, cd + 1});  // 거리 하나 더 늘려서 넣기
                        visited[nx][ny] = true; // 방문 처리
                    }
                }
            }
        }
    }
}