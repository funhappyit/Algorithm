import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bw = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        int cnt = Integer.valueOf(bf.readLine());
        int index = 0;
        boolean flag = false;
        for(int i=0;i<cnt;i++){
            int num = Integer.valueOf(bf.readLine());
            int length = num - index;
            if(i == 0){
                for(int j=1;j<=length;j++){
                    stack.push(j);
                    bw.append("+\n");
                    index++;
                }
                stack.pop();
                bw.append("-\n");
                continue;
            }
            if(stack.isEmpty()){
                for(int j=1;j<=num-index;j++){
                    stack.push(index+j);
                    bw.append("+\n");
                }
                index+= num-index;
            }
            if(num != stack.peek()){
                for(int j=1;j<=num-index;j++){
                    stack.push(index+j);
                    bw.append("+\n");
                }
                index+= num-index;
            }
            if(num < stack.peek()){
                System.out.println("NO");
                flag = true;
                break;
            }
            if(num == stack.peek()){
                stack.pop();
                bw.append("-\n");
                continue;
            }
        }
        if(!flag){
            System.out.println(bw.toString());
        }

    }
}