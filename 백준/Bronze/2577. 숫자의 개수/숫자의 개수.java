import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] nums = new int[10];
        int result = A * B * C;

        String r = String.valueOf(result);
        for (int i = 0; i < r.length(); i++) {
            int num = Integer.parseInt(String.valueOf(r.charAt(i)));
            nums[num]++;
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
