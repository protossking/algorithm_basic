package 알고리즘이론.브루트포스;

import java.util.Scanner;

public class 백준_11729_하노이탑 {
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cnt = 0;
        ha(1,2,3, N);
        System.out.println(cnt);
        System.out.println(sb);
    }
    static void ha(int from, int temp, int to, int n) {
        cnt ++;
        if(n == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }
        ha(from, to, temp, n-1);
        sb.append(from + " " + to + "\n");
        ha(temp, from, to, n-1);

    }
}
