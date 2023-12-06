import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int visited[];
	static ArrayList<Integer>[] A;
	static int cityCnt;
	static int startCityNum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cityCnt = Integer.valueOf(st.nextToken()); //도시 개수
		int loadCnt = Integer.valueOf(st.nextToken()); //도로 개수
		int loadInfo = Integer.valueOf(st.nextToken()); //거리 정보
		startCityNum = Integer.valueOf(st.nextToken()); //출발 도시 번호
		visited = new int[cityCnt+1];
		A = new ArrayList[cityCnt+1];

		for(int i=1;i<=cityCnt;i++){
			A[i] = new ArrayList<>();
		}
		for(int i=1;i<=loadCnt;i++){
			st = new StringTokenizer(br.readLine());
			int sta = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			A[sta].add(end);
		}
		visited[startCityNum] = 0;
		BFS();
		ArrayList<Integer> resultList = new ArrayList<>();
		for(int i=0;i<=cityCnt;i++){
			if(visited[i] == loadInfo){
				resultList.add(i);
			}
		}
		if(resultList.isEmpty()){
			bw.write("-1");
		}else{
			Collections.sort(resultList);
			for(int i=0;i<resultList.size();i++){
				bw.write(resultList.get(i)+"\n");
			}
		}



		bw.flush();
		bw.close();



	}
	public static void BFS(){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startCityNum);
		while(!queue.isEmpty()){
			int start= queue.poll();
			for(int i=0;i<A[start].size();i++){
				int num = A[start].get(i);
				if(num != startCityNum && visited[num] ==0){
					queue.add(num);
					visited[num] = visited[start]+1;
				}
			}
		}
	}

}