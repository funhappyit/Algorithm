import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int arraySize = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열
        int[] suNum = new int[arraySize];
        for(int i=0;i< arraySize;i++){
            suNum[i] = Integer.valueOf(st.nextToken());
        }

        //결과 배열
        int[] resultNum = new int[arraySize];
        //stack 선언
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arraySize;i++){
            if(i == 0){
                stack.push(i);
                continue;
            }

            if(suNum[stack.peek()] >= suNum[i]){
                stack.push(i);
                       continue;
            }
            if(suNum[stack.peek()]<suNum[i]){
                while(suNum[stack.peek()]<suNum[i]){
                    int index = stack.pop();
                    resultNum[index] = suNum[i];
                    if(stack.isEmpty()){
                        break;
                    }
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            resultNum[index] = -1;
        }
        for(int i=0; i<resultNum.length;i++){
            bw.write(resultNum[i]+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}