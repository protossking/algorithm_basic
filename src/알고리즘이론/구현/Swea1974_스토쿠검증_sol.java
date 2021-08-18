package 알고리즘이론.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea1974_스토쿠검증_sol {
        static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(src));
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        for(int tc = 1; tc <= T; tc++) {

            for(int r = 0; r < 9; r++) {
                st = new StringTokenizer(in.readLine());
                for(int c= 0; c < 9; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            if(checkLine() && checkSquare()) {
                answer = 1;

            }

            sb.append(String.format("#%d %d%n", tc, answer));
        }

        System.out.println(sb.toString());



    }
    static boolean checkLine() {
        boolean[] visited = new boolean[10];
        for(int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for(int c = 0; c < 9; c++) {
                if(visited[map[i][c]]) {
                    return false;
                }else {
                    visited[map[i][c]] = true;
                }
            }
            Arrays.fill(visited, false);
            for(int r =0; r < 9; r++) {
                if(visited[map[r][i]]) {
                    return false;
                } else {
                    visited[map[r][i]] = true;
                }
            }
        }
        return true;
    }
    static boolean checkSquare() {
        boolean[] visited = new boolean[10];
        for(int r = 0; r < 9; r+=3) {
            for(int c = 0; c < 9; c+=3) {
                Arrays.fill(visited, false);
                for(int r2 = r; r2 < r + 3; r2++) {
                    for(int c2 = c; c2 < c + 3; c2++) {
                        if(visited[map[r2][c2]]) {
                            return false;
                        }else {
                            visited[map[r2][c2]] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    static String src = "10\r\n" +
            "7 3 6 4 2 9 5 8 1\r\n" +
            "5 8 9 1 6 7 3 2 4\r\n" +
            "2 1 4 5 8 3 6 9 7\r\n" +
            "8 4 7 9 3 6 1 5 2\r\n" +
            "1 5 3 8 4 2 9 7 6\r\n" +
            "9 6 2 7 5 1 8 4 3\r\n" +
            "4 2 1 3 9 8 7 6 5\r\n" +
            "3 9 5 6 7 4 2 1 8\r\n" +
            "6 7 8 2 1 5 4 3 9\r\n" +
            "7 3 6 4 8 9 2 5 1\r\n" +
            "8 5 2 7 3 1 6 9 4\r\n" +
            "9 1 4 5 6 2 7 3 8\r\n" +
            "4 9 7 2 5 6 8 1 3\r\n" +
            "5 6 3 1 8 7 9 4 2\r\n" +
            "2 8 1 9 4 3 5 6 7\r\n" +
            "6 7 5 3 2 4 1 8 9\r\n" +
            "1 4 9 6 7 8 3 2 5\r\n" +
            "3 2 8 1 9 5 4 7 6\r\n" +
            "2 4 6 7 5 3 1 9 8\r\n" +
            "7 5 8 1 9 4 2 3 6\r\n" +
            "3 9 1 2 6 8 7 5 4\r\n" +
            "5 8 2 3 4 6 9 7 1\r\n" +
            "1 6 3 9 7 2 4 8 5\r\n" +
            "9 7 4 8 1 5 6 2 3\r\n" +
            "4 2 7 5 8 1 3 6 9\r\n" +
            "6 3 5 4 2 9 8 1 7\r\n" +
            "8 1 9 6 3 7 5 4 2\r\n" +
            "8 4 5 2 9 6 1 3 7\r\n" +
            "1 3 6 7 5 8 4 9 2\r\n" +
            "9 7 2 1 3 4 6 5 8\r\n" +
            "2 9 7 4 6 3 8 5 1\r\n" +
            "4 6 1 5 8 2 9 7 3\r\n" +
            "5 8 3 9 7 1 2 4 6\r\n" +
            "3 2 8 6 4 5 7 1 9\r\n" +
            "7 1 4 3 2 9 6 8 5\r\n" +
            "6 5 9 8 1 7 3 2 4\r\n" +
            "4 5 7 1 6 3 8 2 9\r\n" +
            "6 3 9 8 2 7 5 4 1\r\n" +
            "7 9 3 4 8 5 1 6 2\r\n" +
            "1 8 2 5 4 9 6 3 7\r\n" +
            "8 6 1 7 9 2 3 5 4\r\n" +
            "5 2 4 6 3 1 7 9 8\r\n" +
            "3 7 6 9 1 4 2 8 5\r\n" +
            "2 4 5 3 7 8 9 1 6\r\n" +
            "9 1 8 2 5 6 4 7 3\r\n" +
            "1 5 2 3 8 6 9 4 7\r\n" +
            "4 8 3 2 7 9 1 5 6\r\n" +
            "7 6 9 1 5 4 8 2 3\r\n" +
            "2 1 8 6 4 7 5 3 9\r\n" +
            "6 9 7 5 3 8 2 1 4\r\n" +
            "5 3 4 9 1 2 6 7 8\r\n" +
            "9 7 1 4 6 5 3 8 2\r\n" +
            "8 2 5 7 9 3 4 6 1\r\n" +
            "3 4 6 8 2 1 7 9 5\r\n" +
            "1 5 8 6 7 2 3 4 9\r\n" +
            "7 2 9 3 4 8 5 1 6\r\n" +
            "6 3 4 5 1 9 7 2 8\r\n" +
            "8 9 2 1 2 5 6 7 4\r\n" +
            "3 7 6 8 9 4 2 5 1\r\n" +
            "5 4 1 7 3 6 8 9 3\r\n" +
            "2 8 7 9 6 1 4 3 5\r\n" +
            "4 1 5 2 8 3 9 6 7\r\n" +
            "9 6 3 4 5 7 1 8 2\r\n" +
            "1 2 4 9 3 6 7 8 5\r\n" +
            "7 8 6 2 4 5 3 9 1\r\n" +
            "3 9 5 1 7 8 2 4 6\r\n" +
            "5 1 9 4 6 2 8 7 3\r\n" +
            "4 6 7 8 9 3 5 1 2\r\n" +
            "8 3 2 5 1 7 9 6 4\r\n" +
            "9 7 3 6 5 4 1 2 8\r\n" +
            "6 5 8 7 2 1 4 3 9\r\n" +
            "2 4 1 3 8 9 6 5 7\r\n" +
            "5 9 3 8 4 1 7 6 2\r\n" +
            "2 1 8 7 6 3 4 9 5\r\n" +
            "7 6 4 9 2 5 1 3 8\r\n" +
            "4 3 6 5 9 2 8 1 7\r\n" +
            "1 8 5 4 3 7 9 2 6\r\n" +
            "9 2 7 1 8 6 5 4 3\r\n" +
            "3 4 1 6 5 8 2 7 9\r\n" +
            "6 5 9 2 7 4 3 8 1\r\n" +
            "8 7 2 3 1 9 6 5 4\r\n" +
            "7 1 4 5 8 9 2 3 6\r\n" +
            "8 5 2 3 6 4 7 1 9\r\n" +
            "3 6 9 1 7 2 8 5 4\r\n" +
            "2 3 1 9 4 6 5 7 8\r\n" +
            "6 8 5 7 3 2 9 4 1\r\n" +
            "9 4 7 8 1 5 3 6 2\r\n" +
            "1 7 8 6 9 3 4 2 5\r\n" +
            "4 2 3 1 5 8 6 9 7\r\n" +
            "5 9 6 4 2 7 1 8 3\r\n" +
            "";
}
