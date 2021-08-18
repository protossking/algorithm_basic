package 알고리즘이론.분할정복;

import java.util.Scanner;

public class 백준_2630_색종이만들기_Sol2 {


    static int N;
    static int[][] map;
    static int blue;
    static int white;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

            }
        }
        blue = 0;
        white = 0;
        ColorPaper(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void ColorPaper(int r, int c, int length) {
        int sColor = map[r][c];

        for(int i = r; i < r + length; i++) {
            for(int j = c; j < c +length; j++) {
                if(map[i][j] != sColor) {
                    length = length /2;
                    ColorPaper(r, c, length);
                    ColorPaper(r, c + length, length);
                    ColorPaper(r + length, c, length);
                    ColorPaper(r + length, c + length , length);
                    return;
                }
            }
        }
        if(map[r][c] == 1) {
            blue++;
        } else {
            white++;
        }
        return;



    }

}
