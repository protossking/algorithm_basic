package 알고리즘이론.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_연산자끼워넣기_14888 {

    static int N;
    static int[] nums;
    static int[] operator;
    static int[] order;

    static int max;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        nums = new int[N];
        operator = new int[4];
        order = new int[N];


        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;


        recur(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void recur(int depth) {

        if(depth == N-1) {
           int value = nums[0];
            for(int i = 0; i < N-1; i++) {
                if(order[i] == 0) {
                    value = value + nums[i+1];
                }
                if(order[i] == 1) {
                    value = value - nums[i+1];
                }
                if(order[i] == 2) {
                    value = value * nums[i+1];
                }
                if(order[i] == 3) {
                    value = value / nums[i+1];
                }
            }

            max = Math.max(value, max);
            min = Math.min(value, min);

        }
        for(int i = 0; i < 4; i++) {
            if(operator[i] > 0) {

                operator[i]--;
                order[depth] = i;
                recur(depth + 1);
                operator[i]++;
                order[depth] = 0;
            }
        }
    }

}
