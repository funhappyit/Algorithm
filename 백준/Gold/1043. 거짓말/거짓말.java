import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int[] parent;
	public static int[] trueP;
	public static int result;
	public static ArrayList<Integer>[] party;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		trueP = new int[T];
		result = 0;
		for(int i=0;i<T;i++){ //진실을 아는 사람 저장하기
			trueP[i] = sc.nextInt();
		}
		party = new ArrayList[M];
		for(int i=0;i<M;i++){
			party[i] = new ArrayList<Integer>();
			int party_size = sc.nextInt();
			for(int j=0;j<party_size;j++){
				party[i].add(sc.nextInt());
			}
		}
		parent = new int[N+1];
		for(int i=0;i<=N;i++){
			parent[i] = i;
		}

		for(int i=0;i<M;i++){
			int firstPeople = party[i].get(0);
			for(int j=1;j<party[i].size();j++){
				union(firstPeople,party[i].get(j));
			}
		}
		//각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없음
		for(int i=0;i<M;i++){
			boolean isPossible = true;
			int cur = party[i].get(0);
			for(int j=0;j< trueP.length;j++){
				if(find(cur) == find(trueP[j])){
					isPossible = false;
					break;
				}
			}
			if(isPossible) result++;
		}
		System.out.println(result);
	}
	public static void union(int first,int sec){
		int a = find(first);
		int b = find(sec);
		 if(a!=b){
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

