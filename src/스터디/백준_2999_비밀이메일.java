package 스터디;

import java.util.Scanner;

public class 백준_2999_비밀이메일 {

        static int r;
        static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s = sc.next().toCharArray();

        int N = s.length;

        for(int i = 1;  i<= N; i++) {
            if(N%i == 0 && i<=N/i) {
                r = i;
                c = N/i;
            }
        }
        int index = 0;
        char[][] map = new char[r][c];
        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                map[j][i] = s[index++];
            }
        }
        for(int i =0; i < r; i++) {
            for(int j =0; j < c; j++) {
                System.out.print(map[i][j]);
            }
        }

    }
}
