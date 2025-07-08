import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[201];
        String[] in = br.readLine().split(" ");
        for(String s: in){
            int num = Integer.parseInt(s) + 100;
            nums[num]++;
        }

        int v = Integer.parseInt(br.readLine());
        System.out.println(nums[v+100]);
    }
}
