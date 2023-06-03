import java.util.Scanner;

import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String str = a.trim();
        int strLength = str.length();
        if(strLength >= 1 && strLength <= 1000000){
            System.out.println(str);
        }
    }
}