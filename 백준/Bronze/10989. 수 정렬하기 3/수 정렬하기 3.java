import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.valueOf(br.readLine());
		int[] numArr = new int[num];
		for(int i=0;i<num;i++){
			numArr[i] = Integer.valueOf(br.readLine());
		}
		Arrays.sort(numArr);

		for(int i=0;i<num;i++){
			bw.write(numArr[i]+"\n");
		}

		bw.flush();
		bw.close();
	}
}