import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long sum = 0;
        int count = 0;

        int num = 1;
        while (true) {
            if (sum > N) break;
            sum += num;
            num++;
            count++;
        }

        System.out.println(count - 1);
    }
}