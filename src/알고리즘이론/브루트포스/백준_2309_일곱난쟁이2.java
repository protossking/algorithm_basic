package 알고리즘이론.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_2309_일곱난쟁이2 {

    static int[] arr;
    static int[] numbers;
    static boolean[] visited;
    static boolean tag;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        numbers = new int[7];
        visited = new boolean[9];


        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        combi(0,0,0);
        Arrays.toString(numbers);


    }


    static void combi(int start,int cnt, int sum) {
        if(cnt == 7) {
            if(sum == 100) {
                System.out.println(Arrays.toString(numbers));
                tag = true;
            }

        }


        for(int i = start; i < arr.length; i++) {

            numbers[cnt] = arr[i];
            combi(i+1, cnt+1, sum + numbers[cnt]);
            combi(i+1, cnt, sum);

            if(tag == true) {
                return;
            }

//            visited[i] = true;
//            numbers[cnt] = arr[i];
//            combi(i+1, cnt + 1, sum + numbers[cnt]);
//            visited[i] = false;

        }

    }




}
