import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 1;
        int rest = 0;
        if (N % 2 == 0) {// 짝수
            rest = 1;
            while (N - rest > 0) {
                result *= (N - rest);
                rest += 2;
            }
        } else {
            result = N;
            rest = 2;
            while (N - rest > 0) {
                result *= (N - rest);
                rest += 2;
            }
        }

        System.out.println(result);
    }
}