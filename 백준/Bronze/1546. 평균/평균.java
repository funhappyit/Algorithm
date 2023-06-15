import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언

		int A = Integer.parseInt(br.readLine());
		String score = br.readLine();
		int[] scoreList = Arrays.stream(score.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

		int max = scoreList[A - 1];
		double sum = 0;

		for (int i = 0; i < scoreList.length; i++) {
			sum += scoreList[i] / Double.valueOf(max * 100) * 10000;
		}
		System.out.println(Double.valueOf(sum / A));
	}
}