import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.valueOf(bf.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=num;i++){
			queue.add(i);
		}
		int index = 0;
		while(queue.size() != 1){
			index+=1;
			if(index%2 ==0){
				int su = queue.poll();
				queue.add(su);
			}else{
				queue.poll();
			}
		}
		bw.write(queue.peek()+"\n");
		bw.flush();
		bw.close();
	}
}