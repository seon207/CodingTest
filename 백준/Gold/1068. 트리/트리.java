import java.util.*;
import java.io.*;

public class Main {
    static int N, num, root, count;
    static int[] arr;
    static boolean[] removed, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        removed = new boolean[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == -1) {
                root = i;   // i번째가 루트
            }
        }

        num = Integer.parseInt(br.readLine());

        if (num == root) {  // 삭제할 노드가 최상위 노드일 때
            System.out.println(0);
        } else {
            remove(num);    // 자식 노드 삭제
            find(root);
            System.out.println(count);
        }
    }

    // 노드 삭제
    public static void remove(int num) {
        removed[num] = true;
        for (int i = 0; i < N; i++) {
            if (arr[i] == num) {
                remove(i);
            }
        }
    }

    public static void find(int num) {
        if (removed[num]) return;
        boolean isLeaf = true;
        if (!removed[num]) {    // 삭제되지 않은 노드일 때
            for (int i = 0; i < N; i++) {
                if (arr[i] == num && !removed[i]) { // 자식이 더 있을 때
                    isLeaf = false; // 단일노드 아님
                    find(i);
                }
            }
            if (isLeaf) count++;
        }
    }
}