
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int tomato;
	static Queue<int[]> q;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = 0; // 익은 토마토
		q = new LinkedList<>();
		max = 0;

		// 입력
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				System.out.println(map[i][j]);
				if (map[i][j] == 1) { // 익은 토마토
					q.add(new int[] { i, j });
					tomato++;
				}
			}
		}

		if (!find()) { // 익은 토마토 없을 때
			System.out.println(0);
		} else {
			bfs();
			if (check()) {
				System.out.println(max - 1);
			} else { // 안익은거 있으면 -1
				System.out.println(-1);
			}
		}

	}

	public static boolean find() { // 안 익은 토마토 있는지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // 안익었을 때
					return true;
				}
			}
		}
		return false;
	}

	public static void bfs() {

		boolean[][] visited = new boolean[N][M];
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			visited[cur[0]][cur[1]] = true;
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 0) { // 범위 안일 때
					q.add(new int[] { nx, ny });
					map[nx][ny] = map[cur[0]][cur[1]] + 1;

					if (max < map[nx][ny]) {
						max = map[nx][ny];
					}
				}

			}
		}
	}

	public static boolean check() { // 안 익은 토마토 있는지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // 안익은 것 있을 때
					return false;
				}
			}
		}
		return true;
	}
}
