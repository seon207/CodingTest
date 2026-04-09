import java.io.*;
import java.util.*;

public class Main {
    static int N, start, end, digit, common;
    static long[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = new long[10];
        start = 1;
        end = N;
        digit = 1;

        while (start <= end) {
            // start의 일의 자리가 0이도록 계산
            while (start % 10 != 0 && start <= end) {
                rest(start);
                start++;
            }

            if (start > end) break;

            // end의 일의 자리가 9이도록 계산
            while (end % 10 != 9 && start <= end) {
                rest(end);
                end--;
            }

            // start~end까지 동일하게 나오는 수
            common = (end / 10 - start / 10 + 1);

            for (int i = 0; i < 10; i++) {
                count[i] += (long) common * digit;
            }

            // 자리 변경
            start /= 10;
            end /= 10;
            digit *= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(count[i] + " ");
        }
    }

    // 나머지 숫자 처리
    static void rest(int num) {
        while (num > 0) {
            count[num % 10] += digit;
            num /= 10;
        }
    }
}