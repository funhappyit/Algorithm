import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String firStr = bf.readLine();
		String secStr = bf.readLine();
		String[] firStrArr = firStr.split(" ");
		String[] secStrArr = secStr.split(" ");

		int cnt = Integer.valueOf(firStrArr[0]);
		int diviCnt = Integer.valueOf(firStrArr[1]);
		long result = 0;

		long[] arrA = new long[cnt];
		long[] arrC = new long[diviCnt];

		for(int i=0;i<cnt;i++){
			int rest = 0;
			if(i == 0){
				rest = (Integer.valueOf(secStrArr[0]))%diviCnt;
				arrA[0] = rest;
				arrC[rest]++;
				if(rest == 0){
					result += 1;
				}
			}else{
				rest = (Integer.valueOf((int)arrA[i-1])+Integer.valueOf(secStrArr[i]))%diviCnt;
				arrA[i] = rest;
				arrC[rest]++;
				if(rest == 0){
					result += 1;
				}
			}

		}

		for(int i=0;i<diviCnt;i++){
			long cNum = arrC[i];
			if(cNum !=0){
				long sum = (cNum*(cNum-1))/2;
				result+=sum;
			}
		}
		System.out.println(result);
	}
}