import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		int[] firstInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] secondInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = firstInput[0];
		int M = firstInput[1];
		int [] resultArr = new int[N+1];
		resultArr[0] = 0;
		for(int i=1;i<resultArr.length;i++){
			resultArr[i] = resultArr[i-1]+secondInput[i-1];
		}
		for(int j=0;j<M;j++){
			int[] index =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			System.out.println(resultArr[index[1]]-resultArr[index[0]-1]);
		}
	}
}