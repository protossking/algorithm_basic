package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2630_색종이만들기 {

    static int[][] map;
    static int white = 0;
    static int black = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        map = new int[T][T];

        for(int i =0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < T; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0,0, T);
        System.out.println(white);
        System.out.println(black);

    }
    static void partition(int row, int col, int size) {
        if(checked(row, col, size)) {
            if(map[row][col] == 0) {
                white ++;
            }
            else {
                black++;
            }
            return;
        }
        // 1 2 3 4
        partition(row, col + size/2, size/2);
        partition(row, col, size/2);
        partition(row + size/2, col, size/2);
        partition(row + size/2, col + size/2, size/2);

    }
    static boolean checked(int row, int col, int size) {
        // 맵 제일 처음에 색깔을 구분해서 원소를 다 돌아서 색이 다같으면 리턴 트루
        int color = map[row][col];

        for(int r = row; r < row + size; r++ ) {
            for(int c = col; c < col + size; c++) {
                if(map[r][c] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
