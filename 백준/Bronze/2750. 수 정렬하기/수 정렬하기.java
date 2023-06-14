import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        int A = Integer.parseInt(br.readLine());
        int B = 0;
        int[] result = new int[A];
        for(int i=0; i<A;i++){
            B = Integer.parseInt(br.readLine());
            result[i] = B;
        }
        Arrays.sort(result);
        br.close();
        for(int j=0; j<result.length;j++){
            System.out.println(result[j]);
        }
    }
}