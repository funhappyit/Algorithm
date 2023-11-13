import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int arraySize = Integer.valueOf(br.readLine());
		int target = Integer.valueOf(br.readLine());

		long start = 1;
		long end = target;

		while(start<end){
			long mid = (start+end)/2; //임의의 x(mid)를 중간 값으로 잡는다.
			long count = 0;
			for(int i=1;i<=arraySize;i++){
				count+=Math.min(mid/i,arraySize);
			}
			if(target<=count){
				end = mid;
			}else{
				start = mid+1;
			}
		}
		bw.write(start+"\n");
		bw.flush();
		bw.close();
	}
}