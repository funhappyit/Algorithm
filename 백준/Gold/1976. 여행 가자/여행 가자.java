import java.util.Scanner;

public class Main {
	public static int[] parent;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] dosi = new int[N+1][N+1];
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				dosi[i][j] = sc.nextInt();
			}
		}
		parent = new int[N+1];
		for(int i=1;i<=N;i++){
			parent[i] = i;
		}

		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				if(dosi[i][j] == 1){
					union(i,j);
				}
			}
		}
		int[] route = new int[M+1];
		for(int i=1;i<=M;i++){
			route[i] = sc.nextInt();
		}
		int index = find(route[1]);
		for(int i=2;i<=M;i++){
			if(index != find(route[i])){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	public static void union(int first,int sec){
		int a = find(first);
		int b = find(sec);
		 if(a<b){
			parent[a] = b;
		 }else{
		 	parent[b] = a;
		 }
	}
	public static int find(int num){
		if(num == parent[num]){
			return num;
		}else{
			return  parent[num] = find(parent[num]);
		}
	}
}

