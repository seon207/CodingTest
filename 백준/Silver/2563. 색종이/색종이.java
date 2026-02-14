import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int P;
	static boolean[][] map;

	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		P = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		StringTokenizer st;
		// 세 장의 색종이
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 색칠
			paint(r, c);
		}
		System.out.println(count);
	}

	// 색칠
	public static void paint(int x, int y) {
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				if (!map[i][j]) {
					map[i][j] = true;
					count++;
				}
			}
		}
	}

}
