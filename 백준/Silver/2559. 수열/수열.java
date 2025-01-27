import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static int N,K;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken());
        temp = new int[N]; 
        max = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            max = max + temp[i]; // 0 ~ K까지의 값 모두 더해서 max로 설정
        }
        
        int sum = max;
        for (int i = K; i < N; i++) {
            // 새로운 값 더하기, 이전 값 빼기
            sum = sum - temp[i - K] + temp[i];
            max = Math.max(max, sum); // 수 갱신
        }

        System.out.println(max);
    }
}