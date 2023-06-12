import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		String timeStr1 = br.readLine();
		String[] timeList = timeStr1.split(" ");

		Integer[] newArr = Stream.of(timeList).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

		int equalCnt = 0;
		int equalNum = 0;
		int max = newArr[0];
		int result = 0;
		for(int i=0;i<newArr.length;i++){
			int count = Collections.frequency(Arrays.asList(newArr),newArr[i]);
			if(equalCnt <= count){
				equalCnt = count;
				equalNum = newArr[i];
			}
			if(max <= newArr[i]){
				max =  newArr[i];
			}

		}
		if(equalCnt == 3){
			result = 10000+(equalNum*1000);
		}else if(equalCnt == 2){
			result = 1000+(equalNum*100);
		}else{
			result = 100*max;
		}

		br.close();

		System.out.println(result);
	}
}
