import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            stack = new Stack<>();
            boolean check = true;
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    stack.push(s.charAt(j));
                } else if (stack.isEmpty()) {
                    check = false;
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty() && check) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);

    }
}