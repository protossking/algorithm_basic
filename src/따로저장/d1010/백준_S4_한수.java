package 따로저장.d1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_S4_한수 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int ans = 0;
        if (N < 100) {
            ans = N;
        }
        if (N == 1000) {
            ans = 144;
        }


        if (N > 99 && N < 1000) {

            for (int i = 100; i <= N; i++) {
                int k = i;
                int a = k % 10;
                k = k / 10;
                int b = k % 10;
                k = k / 10;
                int c = k % 10;

                if((c-b) == (b-a)){
                    ans ++;
                }

            }
            ans += 99;
        }
        System.out.println(ans);


    }
}


/*
 1부터 N 까지

 n 이 100보다 작을때 개수는 n 만큼

 n 이 100보다는 크고 1000보다 는 작을때
 a = n % 10;
 n = n / 10;

 n 이 세자리면
 0 1 비교가 1 2 랑 같을때  한수

 n이 1000이면
 답은 144
 */