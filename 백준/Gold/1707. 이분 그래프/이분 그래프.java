import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static boolean visited[];
    static String abTest[];
    static int testCase;
    static ArrayList<Integer> Arr[];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.valueOf(st.nextToken());
        for(int i=0;i<testCase;i++){
            st = new StringTokenizer(br.readLine());
            int nodeCnt = Integer.valueOf(st.nextToken());
            int edgeCnt = Integer.valueOf(st.nextToken());
            visited = new boolean[nodeCnt+1];
            abTest = new String[nodeCnt+1];
            Arr = new ArrayList[nodeCnt+1];
            for(int k=0;k<=nodeCnt;k++){
                Arr[k] = new ArrayList<>();
            }

            for(int j=0;j<edgeCnt;j++){
                st = new StringTokenizer(br.readLine());
                int fir = Integer.valueOf(st.nextToken());
                int sec = Integer.valueOf(st.nextToken());
                Arr[fir].add(sec);
                Arr[sec].add(fir);
            }
            flag = false;
            for(int r=1;r<=nodeCnt;r++){

                if(DFS(r)){
                    break;
                }
            }
            if(!flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }

    private static boolean DFS(int Node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        if(!visited[Node]){
            abTest[Node] = "A";
        }
        visited[Node] = true;


        while(!queue.isEmpty()){
            int now_Node = queue.poll();
            for(int i=0;i<Arr[now_Node].size();i++){
               int num = Arr[now_Node].get(i);
               String target = abTest[now_Node];
               String test = abTest[num];
                if(target.equals(test)){
                    flag = true;
                    return true;
                }
                   if(!visited[num]){

                       queue.add(num);
                       visited[num] = true;
                       if(target.equals("A")){
                           abTest[num] = "B";
                       }else{
                           abTest[num] = "A";
                       }
                   }

               }

            }
       // }
        return false;
    }
}