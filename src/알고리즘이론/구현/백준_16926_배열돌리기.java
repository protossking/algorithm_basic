package 알고리즘이론.구현;

import java.util.Scanner;

//핵심 배열탐색
// 반시계로 00 에서 꺽을대 값을 저장해 놓은  value 를 이용해 값을 바꿔줌

public class 백준_16926_배열돌리기 {

    static int row;
    static int col;
    static int rot;
    static int[] dr = {0, 1, 0, -1};  // 반시게로   좌 하 우 상
    static int[] dc = {1, 0, -1, 0}; // 좌 하 우 상

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        rot = sc.nextInt();

        int map[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
            }
        } // 입력부분

        int count = Math.min(col, rot) / 2;
        for(int i =0 ; i < rot; i++) {
            for(int j = 0; j < count; j++) {
                int r = j;
                int c = j;

                int dir = 0;
                int value = map[r][c];
                while(dir < 4) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    if(nr < row-j && nc < col-j && nr >= j && nc >= j) {
                        map[r][c] = map[nr][nc];
                        r = nr;
                        c = nc;
                    }else {
                        dir ++;
                    }
                }
                map[j+1][j] = value;
            }
        }

        for(int i =0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();
        }

    }
}
