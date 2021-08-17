package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1992_쿼드트리 {

    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        map = new char[T][T];

        for(int i = 0; i < T; i++) {
            String s  = in.readLine();
            for(int j = 0; j < T; j++) {
                map[i][j] = s.charAt(j);
            }
        }


        partition(0,0, T);
        System.out.println(sb.toString());


    }

    static void partition(int row, int col, int size) {
        if(checked(row, col, size)) {
            sb.append(map[row][col]);
            return;
        }

        size = size /2;
        sb.append('(');
        partition(row, col, size);
        partition(row, col + size, size);
        partition(row + size, col, size);
        partition(row + size, col + size, size);
        sb.append(')');

    }
    static boolean checked(int row, int col, int size) {

        char t = map[row][col];
        for(int r = row; r < row + size; r ++) {
            for(int c = col; c < col + size; c++) {
                if(map[r][c] != t) {
                    return false;
                }
            }
        }
        return true;
    }

}
