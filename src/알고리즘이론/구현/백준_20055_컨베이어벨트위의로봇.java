package 알고리즘이론.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_20055_컨베이어벨트위의로봇 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());

       int[] belt = new int[2*N];
       boolean[] robot = new boolean[N];

       for(int i = 0; i < 2 * N; i++) {
           belt[i] = Integer.parseInt(st.nextToken());
       }


        while (true) {
            int tmp = belt[belt.length-1];

            for(int i = belt.length -1 ; i > 0; i--) {
                belt[i] = belt[i-1];
            }
            belt[0] = tmp;
            for(int i = robot.length-1; i > 0; i--) {
                robot[i] = robot[i-1];
            }
            robot[0] = false;
            robot[N-1] = false;




        }









    }
}
