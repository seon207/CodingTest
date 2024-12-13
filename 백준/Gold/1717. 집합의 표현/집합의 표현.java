import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];

        make();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 1) {   // 1이면 같은 집합인지 확인
                if (check(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {  // 합치기
                combine(a, b);
            }
        }
    }

    public static void combine(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);
        if (rootA < rootB) {    // 작은 것 기준으로 합침
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;
        }
    }

    public static int findParent(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findParent(parents[a]);
    }

    public static boolean check(int a, int b) {
        return findParent(a) == findParent(b);
    }

    public static void make(){
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
    }
}