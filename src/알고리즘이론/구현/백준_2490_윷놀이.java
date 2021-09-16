package 알고리즘이론.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2490_윷놀이 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[3][4];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < map.length; i++) {
            st = new StringTokenizer(in.readLine());

            int cnt = 0;
            for(int j = 0; j < map[i].length; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 0) {
                    cnt ++;
                }
            }
            if(cnt == 0) {
//                System.out.println("E");
                sb.append("E").append("\n");
            }
            else if(cnt == 1){
//                System.out.println("A");
                sb.append("A").append("\n");
            }
            else if(cnt == 2) {
//                System.out.println("B");
                sb.append("B").append("\n");
            }
            else if(cnt == 3) {
//                System.out.println("C");
                sb.append("C").append("\n");
            }
            else if(cnt == 4) {
//                System.out.println("D");
                sb.append("D").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
