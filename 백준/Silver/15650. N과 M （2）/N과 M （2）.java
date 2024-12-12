import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// BOJ_15650 N과 M(2)
public class Main {

	static boolean[] visited;
	static int[] numbers;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		visited = new boolean[N + 1];
		dfs(0, 1);
	}

	public static void dfs(int cnt, int index) {
		if (cnt == M) {
			for (int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		for (int i = index; i < N + 1; i++) {

			numbers[cnt] = i;
			dfs(cnt + 1, i + 1);
		}

	}

}
