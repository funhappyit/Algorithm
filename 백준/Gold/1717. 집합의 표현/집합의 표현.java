import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int quest = sc.nextInt();
            int first = sc.nextInt();
            int sec = sc.nextInt();
            if (quest == 0) {
                union(first, sec);
            } else {
                sameYN(first, sec);
            }
        }
    }

    public static void union(int first, int sec) {
        int a = find(first);
        int b = find(sec);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static int find(int num) {
        if (num == parent[num]) {
            return num;
        } else {
            return parent[num] = find(parent[num]);
        }
        //return num;
    }

    public static void sameYN(int a, int b) {
        if (find(a) == find(b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
