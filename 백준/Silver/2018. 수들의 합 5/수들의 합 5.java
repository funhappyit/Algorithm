import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(br.readLine());
       // Long[] numArr = new Long[num];
        int staIndex = 1;
        int endIndex = 1;

        long sum = 1;
        int result = 1;
        while(endIndex != num){
            if(sum<num){
                endIndex++;
                sum+=endIndex;
            }else if(sum == num){
                result++;
                endIndex++;
                sum+=endIndex;

            }else if(sum > num){
                sum-=staIndex;
                staIndex++;
            }
        }
        System.out.println(result);






    }
}