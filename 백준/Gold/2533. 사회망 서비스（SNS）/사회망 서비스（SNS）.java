import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[][] early;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        early = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[e].add(s);
            list[s].add(e);
        }

        find(1);
        System.out.println(Math.min(early[1][0], early[1][1]));
    }

    public static void find(int start) {
        visited[start] = true;
        early[start][0] = 0;
        early[start][1] = 1;

        for (int friend : list[start]) {
            if (visited[friend]) continue;
            find(friend);
            //현재가 얼리어답터 x
            early[start][0] += early[friend][1];

            //현재가 얼리어답터
            early[start][1] += Math.min(early[friend][0], early[friend][1]);
        }
    }
}