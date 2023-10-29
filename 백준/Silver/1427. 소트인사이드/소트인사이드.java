import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String intputStr = bf.readLine();
        String[] inputArr = intputStr.split("");
        for(int i=0;i<inputArr.length;i++){
            int max = Integer.valueOf(inputArr[i]);
            for(int j=i;j<inputArr.length;j++){
                int jNum = Integer.valueOf(inputArr[j]);
                if(jNum>max){
                   inputArr[j] = String.valueOf(max);
                   inputArr[i] = String.valueOf(jNum);
                   max = jNum;
                }
            }
        }
        for(int i=0;i< inputArr.length;i++){
            bw.write(inputArr[i]);
        }
        bw.flush();
        bw.close();
    }
}