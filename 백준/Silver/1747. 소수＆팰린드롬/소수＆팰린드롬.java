import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		long[] Arr = new long[10000001];
		for(int i=2;i< Arr.length;i++){
			Arr[i] = i;
		}
		for(int i=2;i<Math.sqrt(Arr.length);i++){
			if(Arr[i] == 0){
				continue;
			}
			for(int j=i+i;j<Arr.length;j= j+i){
				Arr[j] = 0;
			}
		}
		for(int i=0;i<Arr.length;i++){
			if(Arr[i] != 0 && Arr[i]>=num){
				String tempNum = String.valueOf(Arr[i]);
				if(isPalimdrome(tempNum)){
					System.out.println(tempNum);
					break;
				}
			}
		}
	}
	public static boolean isPalimdrome(String tempNum){
		int start = 0;
		int end = tempNum.length()-1;
		while(start<=end){
			if(tempNum.charAt(start) != tempNum.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
}