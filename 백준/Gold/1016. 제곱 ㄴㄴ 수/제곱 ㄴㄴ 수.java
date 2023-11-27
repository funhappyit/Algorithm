import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		//최댓값과 최솟값의 차이만큼 배열 선언하기
		boolean[] Check = new boolean[(int)(max-min+1)];
		//2의 제곱수인 4부터 max보다 작거나 같은 값까지 반복하기
		for(long i=2;i*i<=max;i++){
			long pow = i*i; //제곱수
			//Check[(int)pow] = true;
			long startIndex = min/pow;
			if(min%pow != 0)
				startIndex++;
			for(long j=startIndex;pow*j<=max;j++){
				Check[(int)((j*pow)-min)] =true;
			}
		}
		int count = 0;
		for(long i=0;i<=max-min;i++){
			if(!Check[(int)i]){
				count++;
			}
		}

		System.out.println(count);
	}
}