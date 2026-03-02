
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] isSelected; // 선택된 값 저장
	static int[] S;
	static int[] B;
	static int min_diff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 클래스 변수 N을 설정합니다.
		isSelected = new boolean[N];
		S = new int[N];
		B = new int[N];
		min_diff = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) { // 신맛 쓴맛 저장
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			S[i] = Integer.parseInt(st.nextToken()); // 신맛
			B[i] = Integer.parseInt(st.nextToken()); // 쓴맛
		}

		cal(0);
		// 선택되지 않은 항목이 있는 경우를 처리하기 위해 최소 차이를 출력
		System.out.println(min_diff);
	}

	public static void cal(int cnt) {
		if (cnt == N) { // 모든 항목을 고려했을 때
			int s_sum = 1;
			int b_sum = 0;
			boolean selected = false; // 선택된 항목이 있는지 확인

			for (int i = 0; i < N; i++) {
				if (isSelected[i]) { // 선택된 값일 때
					selected = true; // 선택됐을 때만 최소 계산
					s_sum *= S[i]; // 신맛 합
					b_sum += B[i]; // 쓴맛 합
				}
			}

			if (selected) {
				min_diff = Math.min(min_diff, Math.abs(s_sum - b_sum));
			}

			return;
		}

		// 선택
		isSelected[cnt] = true;
		cal(cnt + 1);

		// 비선택
		isSelected[cnt] = false;
		cal(cnt + 1);
	}
}
