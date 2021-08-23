package 알고리즘이론.브루트포스;

import java.util.Scanner;

public class 백준_2501_약수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int K = Integer.parseInt(sc.next());
        int cnt = 0;
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(N%i == 0) {
                cnt ++;
            }
            if(cnt == K) {
                ans = i;
                break;
            }

        }
        System.out.println(ans);


    }
}
