import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		long Min = sc.nextLong();
		long Max = sc.nextLong();
		long[] A = new long[10000001];
		for(int i=2;i<A.length;i++){
			A[i] = i;
		}
		for(int i=2;i<Math.sqrt(A.length);i++){
			if(A[i] == 0){
				continue;
			}
			for(int j=i+i;j<A.length;j=j+i){ // 배수 지우기
				A[j] = 0;
			}
		}
		int count =0;
		for(int i=2;i<10000001;i++){
			if(A[i] != 0){
				long temp = A[i];
				while((double)A[i]<=(double)Max/(double)temp){
					if((double)A[i] >= (double)Min/(double)temp){
						count++;
					}
					temp = temp*A[i];
				}
			}
		}


		bw.write(count+"\n");
		bw.flush();
		bw.close();
	}
}