import java.util.Scanner;

public class Main {
    public static int MAX(int i, int j, int k){
        if(i > j)
            return i>k ? i:k;
        else
            return j>k ? j:k;

    }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            //dp 배열은 포도주의 누적합
            int dp[] = new int[num+1];
            //a 배열은 포도주의 양을 담는 배열
            int a[] = new int[num+1];

            for(int i=1;i<=num;i++){
                a[i]=sc.nextInt();
            }
            for(int i=1;i<=num;i++){
                if(i<4){
                    //포도주가 1개 혹은 2개인 경우
                    if(i != 3)
                        dp[i] = a[i]+dp[i-1];
                        else
                            dp[i] = MAX(a[i]+a[i-1],a[i-1]+a[i-2],a[i]+a[i-2]);
                }

                //알고리즘 부분
                else{
                    dp[i] = MAX(dp[i-1],a[i]+dp[i-2],a[i]+a[i-1]+dp[i-3]);
                }
            }
            System.out.println(dp[num]);
       }
}
