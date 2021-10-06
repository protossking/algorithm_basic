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
        int cnt = 0;
        int level = 0;

       int[] belt = new int[2*N];
       boolean[] robot = new boolean[N];


       for(int i = 0; i < 2 * N; i++) {
           belt[i] = Integer.parseInt(st.nextToken());
       }



        while (true) {

            int tmp = belt[belt.length-1];
            cnt = 0;
            for(int i = belt.length-1; i >0; i--) {
                belt[i] = belt[i-1];
            }
            belt[0] = tmp;


            for(int i = robot.length-1; i > 0; i--) {
                robot[i] = robot[i-1];
            }
            robot[0] = false;
            robot[N-1] = false;

            for(int i = N-1; i >0; i--) {
                if(robot[i -1] && !robot[i] && belt[i] >= 1) {
                    robot[i] = true;
                    robot[i-1] = false;
                    belt[i] --;
                }
            }

            if(belt[0] > 0) {
                robot[0] = true;
                belt[0] --;
            }

            for(int i = 0; i < belt.length; i++) {
                if(belt[i]  == 0 ) {
                    cnt++;
                }
            }
            if(cnt >= K) {
                break;
            }
            level++;




        }
        System.out.println(level+1);









    }



}
