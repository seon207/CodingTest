import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] one = new int[41];
        int[] zero = new int[41];
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            zero[0] = 1;
            one[1] = 1;
            for (int j = 2; j < 41; j++) {
                zero[j] = zero[j - 1] + zero[j - 2];
                one[j] = one[j - 1] + one[j - 2];
            }

            System.out.println(zero[N] + " " + one[N]);
        }

    }
}