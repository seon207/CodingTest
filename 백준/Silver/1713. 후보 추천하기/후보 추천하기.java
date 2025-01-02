
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {

	int time; // 등록된 시간
	int count; // 추천 횟수
	int total_count;

	@Override
	public int compareTo(Pair o) {
		if (o.total_count == this.total_count) { // 추천받은 횟수 같을 때 시간 순으로
			return this.time - o.time;
		} else if (this.total_count < o.total_count)
			return -1;
		else
			return 1;
	}

	public Pair(int time, int count, int total_count) {
		super();
		this.time = time;
		this.count = count;
		this.total_count = total_count;
	}

}

public class Main {

	static int N, C;
	static int[] arr;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		arr = new int[101]; // 나타낼 번호
		ArrayList<Pair> list = new ArrayList<>();
		min = Integer.MAX_VALUE;

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < C; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (arr[num] > 0) { // 이미 등록된 학생일 때
				arr[num]++; // 추천 수 증가
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).count == num) {
						list.get(j).total_count += 1; // 총 추천 횟수
						break;
					}
				}
			} else {
				if (list.size() >= N) {
					Collections.sort(list);
					int count = list.get(0).count;
					arr[count] = 0;
					list.remove(0);
				}
				list.add(new Pair(i, num, 1)); // 추가
				arr[num] = 1;
			}
		}

		for (int i = 0; i < 101; i++) {
			if (arr[i] != 0) {
				System.out.print(i + " ");
			}
		}

	}
}
