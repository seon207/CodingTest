import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int team_size;
	static boolean[] visited;
	static int diff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		team_size = N / 2; // 한 팀의 사이즈
		map = new int[N][N];
		visited = new boolean[N]; // 조합 위한 배열
		diff = Integer.MAX_VALUE; // 최소차이
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find(0, 0);
		System.out.println(diff);

	}

	static void find(int idx, int count) {
		if (count == team_size) { // 조합 다 나왔을 때
			calculate(); // 계산 시작
		}
		// 조합찾기
		for (int i = idx; i < N; i++) {
			if (!visited[i]) { // 방문 안했을 때
				visited[i] = true; // 방문처리
				find(i + 1, count + 1); // 다음
				visited[i] = false; // 방문 취소
			}
		}
	}

	static void calculate() { // 계산
		int result = 0;
		int start_sum = 0;
		int link_sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i] && visited[j]) { // start team일 때
					start_sum += map[i][j];
				} else if (!visited[i] && !visited[j]) { // link 팀일 때
					link_sum += map[i][j];
				}
			}
		}
		result = Math.abs(start_sum - link_sum);
		diff = Math.min(diff, result);
	}

}
