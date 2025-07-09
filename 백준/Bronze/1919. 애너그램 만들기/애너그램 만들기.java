import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        char[] firsts = new char[26];
        char[] seconds = new char[26];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            firsts[c - 97]++;
        }

        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            seconds[c - 97]++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(firsts[i] - seconds[i]);
        }

        System.out.println(result);
    }
}
