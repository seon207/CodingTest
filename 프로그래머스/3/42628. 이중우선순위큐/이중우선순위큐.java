import java.util.*;


class Solution {
    public int[] solution(String[] operations) {
         PriorityQueue<Integer> q1= new PriorityQueue<>((o1,o2)->o2-o1);
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        for(String now: operations){
            StringTokenizer st = new StringTokenizer(now);
            char state =st.nextToken().charAt(0);
            int num =Integer.parseInt(st.nextToken());

            if(state=='I'){
                q1.add(num);
                q2.add(num);
            }
            else{
                if(q1.isEmpty() || q2.isEmpty()){
                    continue;
                }
                if(num==1){
                    q2.remove(q1.poll());
                }
                else{
                    q1.remove(q2.poll());
                }
            }
        }
        
        if (q1.isEmpty() || q2.isEmpty()) return new int[]{0, 0};
        return new int[]{q1.peek(), q2.peek()};
    }
}