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
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int dataCnt = Integer.valueOf(st.nextToken());
        int kNum  = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] dataArr = new int[dataCnt];

        for(int i=0;i<dataCnt;i++){
            dataArr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(dataArr);
        int num = dataArr[kNum-1];

        bw.write(num+"\n");
        bw.flush();
        bw.close();
    }
}