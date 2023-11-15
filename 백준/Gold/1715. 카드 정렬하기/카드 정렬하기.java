import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cardBundleCnt = Integer.valueOf(br.readLine());
		PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
		for(int i=0;i<cardBundleCnt;i++){
			priorityQueueLowest.add(Integer.valueOf(br.readLine()));
		}
		int total = 0;
		if(cardBundleCnt == 1){
			bw.write(0+"\n");
		}else{
			while(!priorityQueueLowest.isEmpty()){
				int sum =priorityQueueLowest.poll()+priorityQueueLowest.poll();
				total+=sum;
				if(!priorityQueueLowest.isEmpty()){
					priorityQueueLowest.add(sum);
				}
			}
			bw.write(total+"\n");
		}
		bw.flush();
		bw.close();
	}
}