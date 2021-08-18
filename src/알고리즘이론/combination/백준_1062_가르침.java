package 알고리즘이론.combination;

import java.util.Arrays;
import java.util.Scanner;
/*
    1. 26개중 5개를 미리 배운걸로 처리
    조합 26Ck-5
 */

public class 백준_1062_가르침 {

    static int N;
    static int K;
    static String[] input;
    static boolean visited[] = new boolean[26];
    static int[] numbers;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 3
        K = sc.nextInt(); // 6
        input = new String[N];

        if(K < 5) {
            System.out.println(0);
            return;
        }
        else if(K == 26) {
            System.out.println(N);
            return;
        } else {
            for(int i =0 ; i < N; i++) {
                String str = sc.nextLine();
                str =str.replace("anta", "");
                str = str.replace("tica", "");
                input[i] = str;

            }
        }
        visited['a' - 97] = true;
        visited['n' - 97] = true;
        visited['t' - 97] = true;
        visited['i' - 97] = true;
        visited['c' - 97] = true;
        numbers = new int[K-5];



        combination(0,0);



    }

    static void combination(int cnt, int start) {
        if(cnt == K-5) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i = start; i < 26; i++) {
            if(visited[i]) continue;
            numbers[cnt] = i;
            visited[i] = true;
            combination(cnt+1, i+1);
            visited[i] = false;

        }
    }
}
