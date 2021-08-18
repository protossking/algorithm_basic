package 따로저장;

import java.io.IOException;
import java.util.Scanner;

public class 백준_1009_분산처리 {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int t;

        for(int i = 0; i < T; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
                t = 1;
            for(int j = 0; j < b; j++) {

                t = t * a % 10;

                if(t == 0) {
                    t = 10;
                }

            }
            System.out.println(t);
        }



    }











}
