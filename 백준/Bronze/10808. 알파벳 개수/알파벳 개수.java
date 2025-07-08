import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = new char[26];
        String s = br.readLine();

        for(int i = 0; i<s.length(); i++){
            int c = s.charAt(i) - 97;
            words[c]++;
        }

        for(int i : words){
            System.out.print(i + " ");
        }
    }
}
