// import java.io.*;
// import java.util.*;

// class Solution {
//     static int[][] cost;
//     static int N;
//     static Queue<int[]> queue;
//     static boolean[][] visited;
//     static int[] dx = {0,1,0,-1};
//     static int[] dy = {1,0,-1,0};
//     public int solution(int[][] board) {
//         queue = new ArrayDeque<>();
//         N = board.length;
//         cost = new int[N][N];
//         visited = new boolean[N][N];
        
//         for(int i = 0; i < N; i++){
//             Arrays.fill(cost[i], 15000);
//         }
//         cost[0][0] = 0;
        
//         queue.offer(new int[]{0,0});
//         visited[0][0] = true;
//         while(!queue.isEmpty()){
//             int[] cur = queue.poll();
//             int x = cur[0];
//             int y = cur[1];
            
//             for(int i = 0; i < 4; i++){
//                 int nx = x + dx[i];
//                 int ny = y + dy[i];
//                 if(nx >= N || ny >= N || nx < 0 || ny < 0 || board[nx][ny] == 1 || visited[nx][ny]) continue; 
//                 int c = 0;
//                 if(Math.abs(ccur[0] - nx) + Math.abs(ccur[1] - ny) == 2){   // 코너일 때
//                     c += 600;
//                 }else{
//                     c += 100;
//                 }
                
//                 cost[nx][ny] = Math.min(cost[nx][ny], c + cost[x][y]);
//                 visited[nx][ny] = true;
//                 queue.offer(new int[]{nx,ny});
//             }
//         }
        
//         int answer = cost[N-1][N-1];
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    static int N;
    static int[][] board;
    static int[][][] dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Node {
        int x, y, dir, cost;
        Node(int x, int y, int dir, int cost) {
            this.x = x; 
            this.y = y; 
            this.dir = dir; 
            this.cost = cost;
        }
    }

    public int solution(int[][] b) {
        board = b;
        N = board.length;

        dist = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        for (int dir = 0; dir < 4; dir++) {
            dist[0][0][dir] = 0;
        }
        pq.offer(new Node(0, 0, -1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cost = cur.cost;

            if (dir != -1 && cost > dist[x][y][dir]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (board[nx][ny] == 1) continue;

                int ncost = cost + 100;
                if (dir != -1 && dir != d) ncost += 500;
                if (ncost < dist[nx][ny][d]) {
                    dist[nx][ny][d] = ncost;
                    pq.offer(new Node(nx, ny, d, ncost));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int dir = 0; dir < 4; dir++) {
            ans = Math.min(ans, dist[N-1][N-1][dir]);
        }
        return ans;
    }
}