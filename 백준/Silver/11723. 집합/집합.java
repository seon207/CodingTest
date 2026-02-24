

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int result = 0; // 연산할 초기값
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int val = 0;
			switch (st.nextToken()) {
			case "add": // 추가
				val = Integer.parseInt(st.nextToken());
				result |= (1 << (val - 1));
				break;
			case "check": // 값 있으면 1, 없으면 0
				val = Integer.parseInt(st.nextToken());
				if ((result & (1 << (val - 1))) > 0) { // 1 이상이면
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n"); // 0이면
				}
				break;
			case "remove": // 제거
				val = Integer.parseInt(st.nextToken());
				result &= ~(1 << (val - 1));
				break;
			case "toggle": // 있으면 제거, 없으면 추가
				val = Integer.parseInt(st.nextToken());
				result ^= (1 << (val - 1));
				break;
			case "all": // {1,2,3,...20}
				result |= ~(0);
				break;
			case "empty": // 전부 초기화
				result &= 0;
				break;
			}
		}
		System.out.println(sb);
	}
}
