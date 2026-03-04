import java.io.BufferedReader;
import java.io.InputStreamReader;

//BOJ_2023 신기한 소수
public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    //자릿수
        //앞자리 2,3,5,7에 대해 실행
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    public static void dfs(int num, int cnt) {
        if (cnt == N) { //자릿수 도달
            if (isPrime(num)) {   //소수이면
                System.out.println(num);
            }
        }
        for (int i = 1; i <= 9; i++) {  //1부터 9까지
            if (i % 2 == 0) { //짝수이면 패스
                continue;
            }
            if (isPrime(num * 10 + i)) {    //한자릿수 더한 값이 소수이면
                dfs(num * 10 + i, cnt + 1);   //계산한 값과 자릿수 전달
            }
        }
    }

    public static boolean isPrime(int num) { //소수 판별
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) { //나눠져 0이되면 소수가 아님
                return false;
            }
        }
        return true;
    }
}
