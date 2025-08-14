// 1967 트리의 지름

import java.util.*;
import java.io.*;

public class Main {
    static int n, max;
    static ArrayList<int[]> arrayList[];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        arrayList = new ArrayList[n + 1];

        for (int i = 1; i < arrayList.length; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arrayList[a].add(new int[]{b, c});
            arrayList[b].add(new int[]{a, c});
        }

        for (int i = 1; i < n; i++) {
            visited = new boolean[n + 1];
            dfs(i, 0);  // 계산 시작
        }

        System.out.println(max);
    }

    public static void dfs(int num, int dist) {
        visited[num] = true;    // 방문
        max = Math.max(dist, max);

        for (int[] node : arrayList[num]) {
            int next = node[0];
            int weight = node[1];

            if (!visited[next]) {
                dfs(next, weight + dist);
            }
        }

    }
}