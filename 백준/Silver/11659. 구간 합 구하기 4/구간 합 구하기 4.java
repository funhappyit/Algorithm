import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String firStr = sc.readLine();
        String secStr = sc.readLine();
        String[] firStrArr = firStr.split(" ");
        String[] secStrArr = secStr.split(" ");

        int dataCnt = Integer.valueOf(firStrArr[0]);
        int questCnt = Integer.valueOf(firStrArr[1]);

        Long[] sumArray = new Long[dataCnt+1];
        sumArray[0] = 0L;
        sumArray[1] = Long.valueOf(secStrArr[0]);
        for(int j=1;j<=dataCnt;j++){
           if (j != 1){
               sumArray[j] = sumArray[j-1]+ Long.valueOf(secStrArr[j-1]);
            }
        }

        for(int i=0;i<questCnt;i++){
            String thStr = sc.readLine();
            String[] thiStrArr = thStr.split(" ");
            int firIndex = Integer.valueOf(thiStrArr[0])-1;
            int lastIndex = Integer.valueOf(thiStrArr[1]);
            System.out.println(sumArray[lastIndex]-sumArray[firIndex]);
        }
    }
}