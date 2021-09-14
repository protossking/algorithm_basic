package 알고리즘이론.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연습장 {

    static char[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        String[] s = {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"};
        String[] s2 = {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"};
        String[] s3 ={"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"};

        map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = s3[i].charAt(j);
            }
        }
        int ans = 1;
        top:
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {

                if (map[r][c] == 'P') {

                    for(int l = 1; l <=2; l++) {
                        for (int adj = 0; adj < 4; adj++) {
                            int nr = r + dr[adj]*l;
                            int nc = c + dc[adj]*l;
                            if (nr < 5 && nc < 5 && nr > -1 && nc > -1) {
                                if(map[nr][nc] == 'X') {
                                    break;
                                }
                                if(map[nr][nc] == 'P') {
                                    ans = 0;
                                    break top;
                                }


                            }


                        }
                    }



                }


            }
        }
        System.out.println(ans);


    }


}
