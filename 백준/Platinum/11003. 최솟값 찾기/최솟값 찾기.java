import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Deque<Node> queue = new LinkedList();
        int num = Integer.valueOf(st.nextToken());
        int slidWidowSize = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=num;i++){
            int inputVal = Integer.valueOf(st.nextToken());
            if(!queue.isEmpty()){
                int endVal = queue.getLast().value;
                int staIndex = queue.getFirst().index;
                if(endVal>inputVal){
                    while (!queue.isEmpty()&&queue.getLast().value >= inputVal){
                        queue.removeLast();
                    }
                }

                if(i - staIndex >= slidWidowSize && !queue.isEmpty()){
                    queue.removeFirst();
                }
                queue.add(new Node(i,inputVal));
            }else{
                queue.add(new Node(i,inputVal));
            }



            bw.write(queue.getFirst().value+" ");
        }

        bw.flush();
        bw.close();

    }
    static class Node{
        public int index;
        public int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}