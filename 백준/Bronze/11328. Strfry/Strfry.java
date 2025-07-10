import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            if (first.equals(second)) {
                System.out.println("Possible");
            } else { // 다를 때
                char[] firsts = new char[26];
                char[] seconds = new char[26];

                for (int j = 0; j < first.length(); j++) {
                    firsts[first.charAt(j) - 97]++;
                }

                for (int j = 0; j < second.length(); j++) {
                    seconds[second.charAt(j) - 97]++;
                }

                boolean check = true;
                for (int j = 0; j < 26; j++) {
                    if (firsts[j] != seconds[j]) {
                        check = false;
                    }
                }

                if (check) {
                    System.out.println("Possible");
                } else {
                    System.out.println("Impossible");
                }
            }
        }
    }
}
