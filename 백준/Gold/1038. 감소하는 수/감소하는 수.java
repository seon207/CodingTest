import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// BOJ_1038 감소하는 수
// 0~9 숫자로 만들 수 있는 방법 -> 2^10(1024)이지만, 아무것도 선택하지 않는 방법을 제외해 1023
// N이 1023 이상이면 수를 만들 수 없음
public class Main {
    static int N;
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        if (N < 11) { // 10 이하인 경우 해당 수 그대로 출력
            System.out.println(N);
        } else if (N > 1022) {  // 수를 만들 수 없음
            System.out.println(-1);
        } else {
            for (int i = 0; i < 10; i++) {  // 0~9까지 돌면서 수 찾음
                make(i, 1);
            }
            Collections.sort(list); // 오름차순 정렬
            System.out.println(list.get(N));
        }
    }

    public static void make(long number, int idx) {
        if (idx > 10) return;   // 자리수가 10 이상이면 감소하는 수 만들 수 없음

        list.add(number);   // list에 숫자 추가
        for (int i = 0; i < number % 10; i++) { // number의 마지막 자리 수보다 작은 수로 시작하는 감소하는 수 찾기
            make((number * 10) + i, idx + 1);
        }


    }
}