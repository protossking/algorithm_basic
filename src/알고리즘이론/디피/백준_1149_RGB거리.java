package 알고리즘이론.디피;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1149_RGB거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[][] map = new int[N][3];


        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N; i++) {
            map[i][0] = Math.min(map[i-1][1], map[i-1][2]) + map[i][0];
            map[i][1] = Math.min(map[i-1][0], map[i-1][2]) + map[i][1];
            map[i][2] = Math.min(map[i-1][0], map[i-1][1]) + map[i][2];
        }


        int min1 = Math.min(map[N-1][0] , map[N-1][1]);
        int min2 = Math.min(min1, map[N-1][2]);
        System.out.println(min2);

    }

}
