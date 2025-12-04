import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> answer;
    
    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        visited = new boolean[n];
        answer = new ArrayList<>();
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        ArrayList<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", tickets, path, 0);
        
        return answer.toArray(new String[0]);
    }
    
    public boolean dfs(String now, String[][] tickets, ArrayList<String> path, int depth) {
        if (depth == tickets.length) {
            answer = new ArrayList<>(path);
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], tickets, path, depth + 1)) {
                    return true;
                }
                
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}