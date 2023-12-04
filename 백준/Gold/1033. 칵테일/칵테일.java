import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Node>[] A;
    static boolean visited[];
    static long min;
    static long D[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.valueOf(br.readLine());
        visited = new boolean[count];
        A = new ArrayList[count];
        D = new long[count];
        min = 1;
        for(int i=0;i<count;i++){
            A[i] = new ArrayList<Node>();
        }
        for(int i=0;i<count-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int p = Integer.valueOf(st.nextToken());
            int q = Integer.valueOf(st.nextToken());
            A[a].add(new Node(b,p,q));
            A[b].add(new Node(a,q,p));
            min *= ((p*q)/gcd(p,q));
        }
        D[0] = min;
        DFS(0);
        long mgcd = D[0];
        for(int i=1;i<D.length;i++){
            mgcd = gcd(mgcd,D[i]);
        }
        for(int i=0;i<D.length;i++){
            System.out.print(D[i]/mgcd+" ");
        }

    }
    private static long gcd(long a,long b){
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }

    private static void DFS(int Node){
        visited[Node] = true;
        for(Node i : A[Node]){
            int next = i.getB();
            if(!visited[next]){
                D[next] = D[Node]*i.getQ()/i.getP();
                DFS(next);
            }
        }
    }
    public static class Node{
        int b;
        int p;
        int q;
        public Node(int b,int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }

        public int getQ() {
            return q;
        }

        public void setQ(int q) {
            this.q = q;
        }
    }
}