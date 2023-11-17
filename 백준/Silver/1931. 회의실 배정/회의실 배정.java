import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int meetingCnt = Integer.valueOf(br.readLine());
		PriorityQueue<meeting> meetingQueue = new PriorityQueue<>(new Comparator<meeting>() {
			@Override
			public int compare(meeting o1, meeting o2) {
				if(o1.endTime == o2.endTime){
					return o1.startTime - o2.startTime;
				}else{
					return o1.endTime - o2.endTime;
				}
			}
		});

		for(int i=0;i<meetingCnt;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetingQueue.add(new meeting(Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken())));
		}
		int firstEnd = meetingQueue.poll().endTime;
		int cnt = 1;
		while(!meetingQueue.isEmpty()){
			int startTime = meetingQueue.peek().startTime;
			if(startTime<firstEnd){
				meetingQueue.remove();
			}else{
				firstEnd = meetingQueue.poll().endTime;
				cnt += 1;
			}

		}
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
	}
	static class meeting{
		int startTime;
		int endTime;
		public meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
}