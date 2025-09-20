import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] alphabets;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        alphabets = new int[27];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                alphabets[c - 'A' + 1] += (int) Math.pow(10, s.length() - j - 1);
            }
        }

        Arrays.sort(alphabets);

        int num = 9;
        int sum = 0;
        for (int i = alphabets.length - 1; i > 0; i--) {
            if (alphabets[i] != 0) {
                sum += num * alphabets[i];
                num--;
            }
        }

        System.out.println(sum);

    }
}