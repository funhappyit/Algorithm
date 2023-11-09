import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int dataCnt = Integer.valueOf(br.readLine());

		int[] Arr = new int[dataCnt];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<dataCnt;i++){
			Arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(Arr);
		int findCnt = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<findCnt;i++){
			int num = Integer.valueOf(st.nextToken());

			int start = 0;
			int end = dataCnt-1;
			boolean flag = false;
			while (start<=end){
				int mid = (start+end)/2;
				if(num > Arr[mid]){
					start = mid+1;
				} else if(num < Arr[mid]){
					end = mid-1;
				}else{
					flag = true;
					break;
				}
			}
			if(flag){
				bw.write(1+"\n");
			}else{
				bw.write(0+"\n");
			}
		}

			bw.flush();
			bw.close();
		}

}