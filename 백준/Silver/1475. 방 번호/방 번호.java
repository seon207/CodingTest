import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[10];   // 숫자 개수 저장할 배열
        String number = br.readLine();
        for (int i = 0; i < number.length(); i++) {
            nums[number.charAt(i) - 48]++;  // 배열에 저장
        }

        int total = nums[6] + nums[9];
        int div = total / 2;
        int rest = total % 2;
        nums[6] = nums[9] = div;
        nums[6] += rest;
        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, nums[i]);
        }
        System.out.println(max);
    }
}
