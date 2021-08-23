package 알고리즘이론.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_2309_일곱난쟁이 {

    static int[] arr;
    static int[] numbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        numbers = new int[7];
        visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        combi(0,0,9,7);



    }

    static void combi(int start,int cnt, int n, int r) {
        if( r== 0) {

                System.out.println(Arrays.toString(numbers));

            return;
        }
        for(int i = start; i < n; i++) {
            visited[i] = true;
            numbers[cnt] = arr[i];
            combi(i+1, cnt + 1, 9, r-1);
            visited[i] = false;
        }



    }


}
