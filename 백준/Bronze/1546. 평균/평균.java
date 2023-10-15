import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] strArray = str.split(" ");
        double result = 0;
        int maxCnt = Integer.valueOf(strArray[0]);
        for(int i=0;i<cnt;i++){
            int tempCnt = Integer.valueOf(strArray[i]);
            if(tempCnt>maxCnt){
                maxCnt = tempCnt;
            }
        }
        for(int j=0;j<cnt;j++){
            Double tmpCnt = Double.valueOf(strArray[j]);

            Double tmpResult = tmpCnt / maxCnt*100;
            result += tmpResult;
        }
        result = result/cnt;
        System.out.print(result);
    }
}
