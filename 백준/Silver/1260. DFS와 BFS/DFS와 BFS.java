import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static StringBuffer bf = new StringBuffer();
    static StringBuffer bfs = new StringBuffer();
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visitedDFS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCnt = Integer.valueOf(st.nextToken());
        int edgeCnt = Integer.valueOf(st.nextToken());
        int firstPoint = Integer.valueOf(st.nextToken());
        visited = new boolean[nodeCnt+1];
        visitedDFS = new boolean[nodeCnt+1];
        A = new ArrayList[nodeCnt+1];
        for(int i=1;i<nodeCnt+1;i++){
            A[i] = new ArrayList<>();
        }
        for(int i=1;i<=edgeCnt;i++){
            st = new StringTokenizer(br.readLine());
            int nodeFir = Integer.valueOf(st.nextToken());
            int nodeSec = Integer.valueOf(st.nextToken());
            A[nodeFir].add(nodeSec);
            A[nodeSec].add(nodeFir);
        }
        for(int i=1;i<=nodeCnt;i++){
            Collections.sort(A[i]);
        }



                DFS(firstPoint);
                BFS(firstPoint);



        System.out.println(bf.toString());
        System.out.println(bfs.toString());


    }
    private static void DFS(int s){
        if(!visited[s]){
            visited[s] = true;
            bf.append(s+" ");
        }
        for(int i=0;i<A[s].size();i++){
            int num = A[s].get(i);
            if(!visited[num]){
                DFS(num);
            }
        }
    }

    private static void BFS(int s){
        visitedDFS[s] = true;

        queue.add(s);
        while(!queue.isEmpty()){
            int num = queue.poll();
            bfs.append(num+" ");
            for(int i=0;i<A[num].size();i++){
                int tmpNum = A[num].get(i);
                if(!visitedDFS[tmpNum]){
                    visitedDFS[tmpNum] = true;
                    queue.add(tmpNum);
                }
            }
        }
    }
}