import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int num = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		num = Integer.valueOf(br.readLine());
		if(num == 1){
			bw.write(2+"\n");
			bw.write(3+"\n");
			bw.write(5+"\n");
			bw.write(7+"\n");
		}else{
			DFS(2,bw);
			DFS(3,bw);
			DFS(5,bw);
			DFS(7,bw);

		}
		bw.flush();
		bw.close();
	}
	private static boolean isPrime(int n) {
		for(int i=2;i<=n/2;i++)
			if(n%i == 0)
				return false;
			return true;
	}
	private static void DFS(int innerNum,BufferedWriter bw) throws IOException {
		int tmpNum = 0;
		String tmpNumStr ="";

		for(int i=1;i<=9;i++){
			tmpNumStr = String.valueOf(innerNum)+String.valueOf(i);
			tmpNum = Integer.valueOf(tmpNumStr);
			if(isPrime(tmpNum)){
				if(num == tmpNumStr.length()){
					bw.write(tmpNum+"\n");
				}
				if(num!=tmpNumStr.length()){
					DFS(tmpNum,bw);
				}
			}
		}
		if(num<=tmpNumStr.length()){
			return;
		}
	}
}