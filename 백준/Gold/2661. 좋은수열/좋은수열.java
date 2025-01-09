import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    static int N;
    static String min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = "";
        perm(0, "");
        System.out.println(min);
    }

    public static void perm(int depth, String str) {
        if (!Objects.equals(min, "")) {   // 이미 답을 찾은 상태일 때
            return;
        }

        if (depth == N) { // 길이 완성했을 때
            min = str;  // 1부터 진행했기 때문에 최소
            return;
        }

        for (int i = 1; i <= 3; i++) {   // 1~3까지 계속 진행
            if (check(str + i)) {   // 좋은 수열인 경우 계속 진행
                perm(depth + 1, str + i);
            }
        }
    }

    public static boolean check(String str) {

        for (int i = 1; i < str.length() / 2 + 1; i++) {    // 전체 길이의 반까지만 확인
            String first = str.substring(str.length() - i * 2, str.length() - i);
            String second = str.substring(str.length() - i);

            if (first.equals(second)) return false;
        }
        return true;
    }
}