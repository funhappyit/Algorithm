import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Long result = 0L;
		st = new StringTokenizer(br.readLine());
		Long[] arr = new Long[N];
		Long[] restArr = new Long[N];

		arr[0] = Long.valueOf(st.nextToken());
		for(int j=1;j<N;j++){
			Long num =  Long.valueOf(st.nextToken());
			arr[j] = num+arr[j-1];
		}

		for(int i=0;i<arr.length;i++){
			int rest = (int)(arr[i]%M);
			restArr[i] = arr[i]%M;
			if(rest == 0){
				result++;
			}

		}

		Stream<Long> longStream = Arrays.stream(restArr);
		Map<Long, Long> map = longStream.collect(
			Collectors.toMap(Function.identity(), value -> 1L, Long::sum)
		);

		for (Map.Entry<Long, Long> pair : map.entrySet()) {
			if(pair.getValue() > 1){
				Long cnt = (pair.getValue()*(pair.getValue()-1))/2;
				result += cnt;
			}
		}
		System.out.println(result);
	}
}