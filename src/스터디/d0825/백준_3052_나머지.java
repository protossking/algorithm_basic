package 스터디.d0825;

import java.util.Scanner;

public class 백준_3052_나머지 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] num = new int[10];
        int[] remain = new int[42];

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        for (int i = 0; i < num.length; i++) {

            int k = num[i] % 42;
            remain[k]++;


        }
        int answer = 0;
        for (int i = 0; i < remain.length; i++) {
            if (remain[i] > 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
