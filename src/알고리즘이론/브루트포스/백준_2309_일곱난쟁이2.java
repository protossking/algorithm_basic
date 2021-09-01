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

        Arrays.toString(numbers);
        combi2(9,7,0,0,0);


    }


    static void combi(int start,int cnt, int sum) {
        if (cnt == 7) {
            if (sum == 100) {
                System.out.println(Arrays.toString(numbers));
                tag = true;
            }
        }
        for (int i = start; i < arr.length; i++) {
            numbers[cnt] = arr[i];
            combi(i + 1, cnt + 1, sum + numbers[cnt]);
            combi(i + 1, cnt, sum);
            if (tag == true) {
                return;
            }

        }
    }
        static void combi2(int n,int r, int sum, int cnt, int start) {
            if(r == 0) {
                System.out.println(Arrays.toString(numbers));
                return;

            }
            if(cnt == 7) {
                return;
            }
                numbers[cnt] = arr[start];
                combi2(n-1, r-1,sum+numbers[cnt], cnt+1, start+1);
                combi2(n, r, cnt+1,sum,start+1);

            }


    }





