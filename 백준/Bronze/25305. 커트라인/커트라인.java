import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        scores = new int[N];
        st =  new StringTokenizer(br.readLine()); 

        for(int i = 0; i < N; i++) { 
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores);

        System.out.println(scores[N-K]);

    }
}