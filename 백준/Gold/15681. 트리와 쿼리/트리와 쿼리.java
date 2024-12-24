import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q;
    static int[] parents;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        parents = new int[N + 1];
        Arrays.fill(parents, 1);

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 그래프
            list[u].add(v);
            list[v].add(u);
        }

        // 루트 기준
        makeTree(R, -1);

        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(parents[query]);
        }
    }

    public static void makeTree(int currentNode, int parent) {
        for (int node : list[currentNode]) {    // 연결된 노드 확인
            if (parent != node) {   // 부모 노드 아닐 때 -> 재귀
                makeTree(node, currentNode);
            }
        }

        // 자식 노드 서브트리 크기를 부모 노드에 더해줌
        if (parent != -1) {
            parents[parent] += parents[currentNode];
        }
    }
}
