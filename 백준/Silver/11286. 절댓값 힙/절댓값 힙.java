import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;

import java.util.PriorityQueue;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.valueOf(bf.readLine());
		//StringTokenizer st = new StringTokenizer(bf.readLine());

	//
	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			int first = Math.abs(o1);
			int sec = Math.abs(o2);
			if(first == sec){
				return o1 > o2? 1:-1;
			}else{
				return first-sec;
			}

		}
	});
	for(int i=0;i<num;i++){
		int stNum = Integer.valueOf(bf.readLine());
		if(stNum!=0){
			priorityQueue.add(stNum);
		}
		if(stNum == 0 && priorityQueue.isEmpty()){
			bw.write(0+"\n");
		}
		if(stNum==0&& !priorityQueue.isEmpty()){
			int prNum = priorityQueue.poll();
			bw.write(prNum+"\n");
		}

	}
	bw.flush();
	bw.close();
	}
}