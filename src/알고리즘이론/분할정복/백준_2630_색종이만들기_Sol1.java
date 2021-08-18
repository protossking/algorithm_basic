package 알고리즘이론.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2630_색종이만들기_Sol1 {

    static int N;
    static int[][] map;
    static int blue;
    static int white;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(in.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }

//        divide
        divide(0,0, N);
        System.out.println(white);
        System.out.println(blue);

    }
    static void divide(int r, int c, int size) {
        if(check(r, c, size)) {
            if(map[r][c] == 1) {
                blue++;
            }else {
                white++;
            }
            return;
        }
        divide(r, c, size/2);
        divide(r, c  + size/2, size/2);
        divide(r + size/2 , c ,size/2);
        divide(r + size/2 , c + size/2 ,size/2);


    }
    static boolean check(int r, int c, int size) {
        int color = map[r][c];
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }


}
