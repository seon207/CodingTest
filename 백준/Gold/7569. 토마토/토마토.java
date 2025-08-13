
import java.util.*;
import java.io.*;

public class Main {

	static int M, N, H;
	static int[][][] box;
	static int[] dx = { 1, 0, -1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static Queue<int[]> list = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[N][M][H];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					int tomato = Integer.parseInt(st.nextToken());
					if (tomato == 1) { // 익어있을 때
						list.offer(new int[] { i, j, k }); // 좌표 추가
					}
					box[i][j][k] = tomato;
				}
			}
		}

		int result = bfs() - 1;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {

					// 안익은 토마토
					if (box[i][j][k] == 0) {
						result = -1;
						break;
					}
				}
			}
		}
		System.out.println(result);

	}

	static int bfs() {
		int x = 0, y = 0, z = 0;
		while (!list.isEmpty()) {
			int[] current = list.poll();
			x = current[0];
			y = current[1];
			z = current[2];
			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nh = z + dh[i];

				// 범위벗어남
				if (nx >= N || ny >= M || nh >= H || nx < 0 || ny < 0 || nh < 0) {
					continue;
				}
				// 안익었을 때
				if (box[nx][ny][nh] == 0) {
					box[nx][ny][nh] = box[current[0]][current[1]][current[2]] + 1;
					list.offer(new int[] { nx, ny, nh });
				}
			}
		}
		return box[x][y][z];
	}
}
