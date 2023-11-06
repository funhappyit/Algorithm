import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//상하좌우를 탐색하기 위한 배열 선언하기
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static int[][] A;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine(),"");
			String str = st.nextToken();
			for(int j=0;j<M;j++){
				A[i][j] = Integer.parseInt(str.substring(j,j+1));
			}
		}
		BFS(0,0);
		System.out.println(A[N-1][M-1]);
	}
	public static void BFS(int i, int j){
		Queue<int[]> queue = new LinkedList<>();
		visited[i][j] = true;
		queue.add(new int[]{i,j});
		while(!queue.isEmpty()){
			int[] now = queue.poll();
			for(int k=0;k<4;k++){
				int x = now[0]+dx[k];
				int y = now[1]+dy[k];
				if(x>=0&y>=0&&x<N&&y<M){
					if(A[x][y]==1&&!visited[x][y]){
						A[x][y] = A[now[0]][now[1]]+1;
						queue.add(new int[]{x,y});
						visited[x][y] = true;
					}
				}
			}
		}
		
	}
}