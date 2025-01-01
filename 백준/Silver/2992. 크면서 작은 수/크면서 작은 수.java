import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int temp[], result[];
	static boolean visited[], flag;
	static String str, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		str = bf.readLine();

		temp = new int[str.length()];
		result = new int[str.length()];
		visited = new boolean[str.length()];
		flag = false;

		for (int i = 0; i < str.length(); i++) {
			temp[i] = str.charAt(i) - '0';
		}

		Arrays.sort(temp);

		search(0);

		if (!flag)
			System.out.println(0);
	}

	private static void search(int idx) {
		if (idx == result.length) {
			answer="";
			for (int i = 0; i < result.length; i++) {
				answer += Integer.toString(result[i]);
			}

			if (!flag && Integer.parseInt(answer) > Integer.parseInt(str)) {
				flag = true;
				System.out.println(answer);
			}

			return;
		}

		for (int i = 0; i < temp.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[idx] = temp[i];
				search(idx + 1);
				visited[i] = false;
				if (flag)
					return;
			}
		}
	}
}
 