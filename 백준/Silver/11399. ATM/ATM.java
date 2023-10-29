import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int dataCnt = Integer.valueOf(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        Long[] dataArr = new Long[dataCnt];
        for(int i=0;i<dataCnt;i++){
            dataArr[i] = Long.valueOf(st.nextToken());
        }
        Arrays.sort(dataArr);
        Long sum = 0L;
        for(int j=0;j<dataArr.length;j++){
            sum += dataArr[j]*(dataCnt-j);
        }
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}