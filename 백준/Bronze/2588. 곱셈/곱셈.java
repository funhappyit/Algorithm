import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int A = sc.nextInt();
       int B = sc.nextInt();
       int C = B;
       if(A>=100 && B>=100){
           ArrayList<Integer> arrNum = new ArrayList<>();
           while(B > 0) {
               arrNum.add(B%10);
               B= B/10;
           }
           for(int i=0;i<arrNum.size();i++){
               System.out.println(A*arrNum.get(i));
           }
           System.out.println(A*C);
       }
    }
}