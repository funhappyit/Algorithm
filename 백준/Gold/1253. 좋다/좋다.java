import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(bf.readLine());
		String str = bf.readLine();
		String[] strNum = str.split(" ");
		Long[] numList = new Long[num];
		for(int i=0;i< strNum.length;i++){
			numList[i] = Long.valueOf(strNum[i]);
		}
		Arrays.sort(numList);

		Long result = 0L;

		for(int i=0;i<num;i++){
			int staIndex = 0;
			int endIndex = num-1;
			Long goal =  numList[i];
			while (staIndex<endIndex){
				if(numList[staIndex]+numList[endIndex] == goal){
					if(staIndex != i && endIndex != i){
						result++;
						break;
					}else if(staIndex == i){
						staIndex++;
					}else if(endIndex == i){
						endIndex--;
					}
				}else if(numList[staIndex]+numList[endIndex] < goal){
					staIndex++;
				}else if(numList[staIndex]+numList[endIndex] > goal){
					endIndex--;
				}

			}
		}
		System.out.println(result);
 	}
}