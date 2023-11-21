import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.valueOf(st.nextToken());
		int end = Integer.valueOf(st.nextToken());
		int[] Arr = new int[end+1];
		for(int i=2;i<=end;i++){
			Arr[i] = i;
		}
		for(int i=2;i<= Math.sqrt(end);i++){
			if(Arr[i] == 0){
				continue;
			}
			for(int j=i+i;j<=end;j=j+i){
				Arr[j] = 0;
			}
		}
		for(int i=start;i<=end;i++){
			if(Arr[i] != 0){
				bw.write(Arr[i]+"\n");

			}
		}
		bw.flush();
		bw.close();
	}
}