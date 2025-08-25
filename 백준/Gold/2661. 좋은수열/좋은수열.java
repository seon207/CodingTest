import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String result;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = "";
        flag = false;
        find(0);
    }

    public static void find(int depth) {
        if (depth == N) {
            if (check()) {
                System.out.println(result);
                flag = true;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (flag) {
                return;
            }
            String temp = result;
            result = result.concat(String.valueOf(i));
            if (check()) {
                find(depth + 1);
            }
            result = temp;
        }
    }

    public static boolean check() {
        int len = result.length();
        for (int i = 1; i <= len / 2; i++) {
            String f = result.substring(len - (i * 2), len - i);
            String e = result.substring(len - i, len);

            if (f.equals(e)) {
                return false;
            }
        }
        return true;
    }
}