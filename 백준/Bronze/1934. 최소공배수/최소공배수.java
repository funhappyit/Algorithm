import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.valueOf(br.readLine());
		for(int i=0;i<cnt;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ANum = Integer.valueOf(st.nextToken());
			int BNum = Integer.valueOf(st.nextToken());
			int max = ANum;
			int min = BNum;
			if(BNum>ANum){
				max=BNum;
			}
			if(ANum<BNum){
				min = ANum;
			}
			System.out.println((ANum*BNum)/gcd(max,min));
		}
	}
	public static int gcd(int max,int min){
		if(max%min == 0){
			return min;
		}else{
			int tempMax = max;
			max = min;
			min = tempMax%min;
			return gcd(max,min);
		}
	}
}