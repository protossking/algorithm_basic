package 스터디;

import java.util.Scanner;

public class 백준_1074_Z {

    static int[][] map;
    static int N;
    static int R;
    static int C;
    static int area;
    static int count;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();
        area = (int) Math.pow(2, N);
        map = new int[area][area];
        count = 0;



        divide(0, 0, area);
        System.out.println(count);

    }
    static void divide(int r, int c, int size) {

        if(R == r && C == c ) {
            System.out.println(count);
            return;
        }


        if( r <= R && R < (r + size) && c <= C && C < (c + size)) {
            size  = size / 2;
            

        }





    }

}
