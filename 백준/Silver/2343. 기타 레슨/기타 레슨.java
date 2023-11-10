import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int lessonCnt = Integer.valueOf(st.nextToken());
		int bluerayCnt = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] Arr = new int[lessonCnt];
		for(int i=0;i<Arr.length;i++){
			Arr[i] = Integer.valueOf(st.nextToken());
		}
		int start = 0;
		int end = 0;
		for(int i=0;i<Arr.length;i++){
			if(Arr[i]>start){
				start = Arr[i];
			}
			end+=Arr[i];
		}
		while(start<=end){
			int med = (start+end)/2;
			int sum =0;
			int count =0;
			for(int i=0;i<Arr.length;i++){
				if(sum+Arr[i]>med){
					count++;
					sum = 0;
				}
				sum = sum+Arr[i];
			}
			count+=1;
			if(count<=bluerayCnt){
				end = med-1;
			}else{
				start = med+1;
			}
		}
		System.out.println(start);
	}
}