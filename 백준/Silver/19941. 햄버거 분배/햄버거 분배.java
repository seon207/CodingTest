import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 무조건 가장 왼쪽에 있는 햄버거 먹도록
 * */
public class Main {
    static int N, K, result;
    static char[] arr;
    static boolean[] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        arr = new char[N];
        check = new boolean[N];

        // 입력
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i);
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {  //사람일 때
                int start = Math.max(i - K, 0); // 시작점(0보다 작은 경우 방지)
                int end = Math.min(i + K, N - 1); // 끝(N-1보다 큰 경우 방지)
                for (int j = start; j <= end; j++) {   // 현재 위치 기준으로 K만큼 확인
                    if (!check[j] && arr[j] == 'H') {    //이미 먹은 햄버거가 아니고, 햄버거가 있을 때
                        check[j] = true;
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}