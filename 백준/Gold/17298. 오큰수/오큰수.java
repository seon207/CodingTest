import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		int[] index = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			index[i] = Integer.parseInt(st.nextToken());
		}
 
 
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && index[stack.peek()] < index[i]) {    //스택 안비어있고 맨 위 원소가 더 클 때
				index[stack.pop()] = index[i];    // 계속 pop
			}
			
			stack.push(i);
		}
		
		
		while(!stack.isEmpty()) {
			index[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(index[i]).append(' ');
		}
		System.out.println(sb);
	}
}