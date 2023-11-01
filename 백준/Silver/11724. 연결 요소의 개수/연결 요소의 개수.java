import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean visited[];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		A = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=1;i<n+1;i++){
			A[i] = new ArrayList<>();
		}
		for(int i=1;i<m+1;i++){
			st = new StringTokenizer(br.readLine());
			int fir = Integer.valueOf(st.nextToken());
			int sec = Integer.valueOf(st.nextToken());
			A[fir].add(sec);
			A[sec].add(fir);
		}
		int count = 0;
		for(int i=1;i<n+1;i++){
			if(!visited[i]){
				count++;
				DFS(i);

			}

		}
		bw.write(count+"\n");
		bw.flush();
		bw.close();
	}

	private static void DFS(int num) {
		if(visited[num]){
			return;
		}else{
			visited[num] = true;
		}
		for(int i=0;i<A[num].size();i++){
			int tmp = A[num].get(i);
			if(!visited[tmp]){
				DFS(tmp);
			}
		}
	}
}