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
		long ANum = Long.valueOf(st.nextToken());
		long BNum = Long.valueOf(st.nextToken());
		long max = ANum;
		long min = BNum;
		if(BNum>ANum){
			max=BNum;
		}
		if(ANum<BNum){
			min = ANum;
		}
		long cnt = gcd(max,min);
		for(long i=0;i<cnt;i++){
			bw.write("1");
		}

		bw.flush();
		bw.close();
	}
	public static long gcd(long max,long min){
		if(max%min == 0){
			return min;
		}else{
			long tempMax = max;
			max = min;
			min = tempMax%min;
			return gcd(max,min);
		}
	}
}