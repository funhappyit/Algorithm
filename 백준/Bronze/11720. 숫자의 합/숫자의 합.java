import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String str = sc.next();
        String[] strArray = str.split("");
        int result = 0;
        for(int i=0;i<cnt;i++){
            result += Integer.valueOf(strArray[i]);
        }
        System.out.print(result);
    }
}
