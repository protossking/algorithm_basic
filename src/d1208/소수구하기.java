package d1208;

import java.util.ArrayList;
import java.util.List;

public class 소수구하기 {

    static int[] numbers;
    static int[] ans;
    static int N;
    static int sum;
    static int answer = 0 ;

    public static void main(String[] args) {

        numbers = new int[]{1, 2, 7, 6, 4};
        ans = new int[3];
        N = numbers.length;

        combi(0, 0);

        System.out.println("answer " + " " + answer);
        List<Integer> list = new ArrayList<>();
        int[][] c = new int[5][3];
        System.out.println(c.length);


    }


    static void combi(int cnt, int start) {
        if(cnt == 3) {
            int sum = 0;
            for(int b : ans) {
                sum += b;
            }
            System.out.println(sum);
            return ;
        }


        for(int i = start; i < N; i++) {
            ans[cnt] = numbers[i];
            combi(cnt+1, i+1);
        }

    }




}
