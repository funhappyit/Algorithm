import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        int A = Integer.parseInt(br.readLine());
        String strArr = br.readLine();
        String[] str = strArr.split("");
        int result =0;
        for(int j=0;j< str.length;j++) {
            result += Integer.parseInt(str[j]);
        }
        br.close();
        System.out.println(result);
    }
}