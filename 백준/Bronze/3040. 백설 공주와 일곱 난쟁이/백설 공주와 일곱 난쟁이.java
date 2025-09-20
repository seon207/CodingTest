import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] arr, num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		num = new int[7];

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dfs(0, 0, 0);

	}

	public static void dfs(int idx, int sum, int cnt) {
		if (cnt == 7) {
			if (sum == 100) { // sum이 100일 때
				for (int n : num) {
					System.out.println(n);
				}
			}
			return;
		}

		if (idx >= 9)
			return;

		num[cnt] = arr[idx];
		dfs(idx + 1, arr[idx] + sum, cnt + 1); // 선택
		dfs(idx + 1, sum, cnt); // 선택 x
	}

}
