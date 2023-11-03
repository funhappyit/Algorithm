import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] Arr;
	static boolean[] visited;
	static boolean arrive;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int humanNum = Integer.valueOf(st.nextToken());
		int friendNum = Integer.valueOf(st.nextToken());
		Arr= new ArrayList[humanNum];
		visited = new boolean[humanNum];
		for(int i=0;i<humanNum;i++){
			Arr[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<friendNum;i++){
			st = new StringTokenizer(br.readLine());
			int firNum = Integer.valueOf(st.nextToken());
			int secNum = Integer.valueOf(st.nextToken());
			Arr[firNum].add(secNum);
			Arr[secNum].add(firNum);
		}

		for(int i=0;i<humanNum;i++){
			int cnt = 0;
			DFS(i,cnt);
			if(arrive){
				break;
			}
		}
		if(arrive){
			bw.write("1"+"\n");
		}else{
			bw.write("0"+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static void DFS(int innerNum,int cnt) throws IOException {
				visited[innerNum] = true;
		if(cnt==4 || arrive){
			arrive = true;
			return;
		}
				for(int j=0;j<Arr[innerNum].size();j++){
					int tmp = Arr[innerNum].get(j);
					if(!visited[tmp]){
						DFS(tmp,cnt+1);
					}

				}
				visited[innerNum] = false;

	}
}