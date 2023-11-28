import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.valueOf(br.readLine());
		long temp = num;
		for(long i=2;i<=Math.sqrt(num);i++){
			if(num%i==0){
				temp = temp-(temp/i);
				while(num%i==0){
					num = num/i;
				}
			}
		}
		if(num>1){
			temp =temp - temp/num;
		}
		System.out.println(temp);
	}
}