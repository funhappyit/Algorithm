import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//6가지 이동 케이스를 표현하기 위한 배열
	static int[] sender = {0,0,1,1,2,2};
	static int[] Receiver = {1,2,0,2,0,1};
	static boolean visited[][]; // A,B의 무게만 있으면 C의 무게가 고정되므로 2개만 체크
	static boolean answer[];
	static int now[];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		now = new int[3];
		now[0] = sc.nextInt(); //A
		now[1] = sc.nextInt(); //B
		now[2] = sc.nextInt(); //C
		visited = new boolean[201][201];
		answer = new boolean[201];
		BFS();
		for(int i=0;i<answer.length;i++){
			if(answer[i]) System.out.print(i+" ");
		}
	}
	public static void BFS(){
		Queue<AB> queue = new LinkedList<>();
		queue.add(new AB(0,0));
		visited[0][0] = true;
		answer[now[2]] = true;
		while (!queue.isEmpty()) {
			AB p = queue.poll();
			int A = p.A;
			int B = p.B;
			int C = now[2] - A - B;
			//A->B
			for(int i=0;i<6;i++){
				int[] next = {A,B,C};
				next[Receiver[i]]+=next[sender[i]];
				next[sender[i]] = 0;
				if(next[Receiver[i]] > now[Receiver[i]]){ //물이 넘칠때
					//초과하는 만큼 다시 이전 물통에 넎어줌
					next[sender[i]] = next[Receiver[i]] - now[Receiver[i]];
					next[Receiver[i]] = now[Receiver[i]];
				}
				if(!visited [next[0]][next[1]]){
					visited [next[0]][next[1]] = true;
					queue.add(new AB(next[0],next[1]));
					if(next[0]==0){
						answer[next[2]] = true;
					}
				}
			}
		}
	}
}
class AB{
	int A;
	int B;
	public AB(int A,int B){
		this.A = A;
		this.B = B;
	}
}


//AB 클래스 선언 -> A와 B의 값만 지고 있으면 C는 유추할 수 있으므로 두 변수만 사용하기
