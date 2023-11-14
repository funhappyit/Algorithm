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

		int coinCnt = Integer.valueOf(st.nextToken());
		long targetAmount = Long.valueOf(st.nextToken());
		long[] coinArr = new long[coinCnt];

		for(int i=0;i<coinCnt;i++){
			coinArr[i] = Long.valueOf(br.readLine());
		}
	//	int count = 0;
		int sum = 0;
		int count = 0;
		for(int i=coinCnt;i>0;i--){
			long maxCoin = Long.valueOf(coinArr[i-1]);
			if(targetAmount>=maxCoin){
				count+= targetAmount/maxCoin;
				targetAmount = targetAmount - (count*maxCoin);

			}
			sum = count+sum;
			count = 0;
			if(targetAmount == 0){
				break;
			}
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	}
}