import java.io.*;
import java.util.*;

public class Main {
    static int N, idx;
    static int[] roots;
    static int[][] cost;
    static ArrayList<Edge> arrayList;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arrayList = new ArrayList<>();
        roots = new int[N + 1];
        cost = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            roots[i] = -1;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
                if (cost[i][j] != 0) {
                    arrayList.add(new Edge(i, j, cost[i][j]));
                }
            }
        }

        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (idx == N - 1) break;
            Edge e = arrayList.get(i);

            if (union(e.start, e.end)) {
                idx++;
                result += e.weight;
            }
        }

        System.out.println(result);
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        roots[rootB] = rootA;
        return true;
    }

    public static int find(int a) {
        if (roots[a] == -1) {
            return a;
        }

        return roots[a] = find(roots[a]);
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}