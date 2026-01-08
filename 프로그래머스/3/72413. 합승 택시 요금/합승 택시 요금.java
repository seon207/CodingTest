import java.io.*;
import java.util.*;

class Solution {
    static int min;
    static boolean[] visited;
    static ArrayList<Info>[] arrayList;
    static int[] distanceA, distanceB, dist;
    
    public static class Info implements Comparable<Info>{
        int start;
        int price;
        
        public Info(int start, int price){
            this.start = start;
            this.price = price;
        }
        
        @Override
        public int compareTo(Info o){
            return this.price - o.price;
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        visited = new boolean[n + 1];
        arrayList = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            arrayList[i] = new ArrayList<Info>();
        }
        
        for(int[] fare: fares){
            int start = fare[0];
            int end = fare[1];
            int price = fare[2];
            
            arrayList[start].add(new Info(end, price));
            arrayList[end].add(new Info(start, price));
        }
        
        // a, b, start에서 가는 최소 요금
        distanceA = dij(a, n);
        distanceB = dij(b, n);
        dist = dij(s, n);
        
        for(int i = 1; i <= n ;i++){
            min = Math.min(min, distanceA[i] + distanceB[i] + dist[i]);
        }
        
        return min;
    }
    
    public static int[] dij(int start, int n){
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Info> queue = new PriorityQueue<>();
        queue.add(new Info(start, 0));
        distance[start] = 0;
        
        while(!queue.isEmpty()){
            Info cur = queue.poll();
            
            for(Info next : arrayList[cur.start]){
                int nextNode = next.start;
                int nextCost = cur.price + next.price;

                if (distance[nextNode] > nextCost) {
                    distance[nextNode] = nextCost;
                    queue.add(new Info(nextNode, nextCost));
                }
            }
        }
        return distance;
    }
}