import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(bf.readLine());
		int objNum = Integer.valueOf(bf.readLine());
		String numStr = bf.readLine();
		String[] numArrStr = numStr.split(" ");
		Long[] numArr = new Long[num];

		int strIndex = 0;
		int endIndex = num-1;
		int result = 0;


		for(int i=0;i<num;i++){
			numArr[i] = Long.valueOf(numArrStr[i]);
		}
		Arrays.sort(numArr);

		while (strIndex <endIndex){
			long sum = numArr[strIndex]+numArr[endIndex];
			if(sum < objNum){
				strIndex++;
			}else if(sum == objNum){
				endIndex--;
				strIndex++;
				result++;
			}else{
				endIndex--;
			}
		}
		System.out.println(result);
	}
}