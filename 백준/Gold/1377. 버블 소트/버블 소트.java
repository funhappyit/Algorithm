import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    //private static int Node;
    static class Node{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.valueOf(bf.readLine());
        //int[] staArr = new int[num];
        Node[] nodelIST = new Node[num];

        for(int i=1;i<=num;i++){
            nodelIST[i-1] = new Node(i,Integer.valueOf(bf.readLine()));

        }
        Arrays.sort(nodelIST, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });
       int max = 0;
        for(int i=1;i<=nodelIST.length;i++){
            int subNum =nodelIST[i-1].index-i;
            if(subNum >max){
                max = subNum;
            }
        }

        bw.write(max+1+"\n");
        bw.flush();
        bw.close();
    }
}