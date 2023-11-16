import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int numCnt = Integer.valueOf(br.readLine());
		PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
		PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<numCnt;i++){
			int num = Integer.valueOf(br.readLine());
			if(num<=0){
				minusQueue.add(num);
			}else{
				plusQueue.add(num);
			}
		}
		int result =0;
		while(!minusQueue.isEmpty()){
			int minusSum =0;
			int prioryNum =0;
			int nextNum = 0;
			if(!minusQueue.isEmpty()){
				prioryNum = minusQueue.poll();
				minusSum = prioryNum;
			}
			if(!minusQueue.isEmpty()){
				nextNum = minusQueue.poll();
				minusSum = prioryNum*nextNum;
			}
			result += minusSum;
		}
		while(!plusQueue.isEmpty()){
			int plusSum =0;
			int prioryNum =0;
			int nextNum =0;
			if(!plusQueue.isEmpty()){
					prioryNum = plusQueue.poll();
					plusSum = prioryNum;
			}
			if(!plusQueue.isEmpty()){
				if(plusQueue.peek() != 1){
					nextNum = plusQueue.poll();
					plusSum = prioryNum*nextNum;
				}
			}
			result += plusSum;

		}
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}