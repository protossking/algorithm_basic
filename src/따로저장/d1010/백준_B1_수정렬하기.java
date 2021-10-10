package 따로저장.d1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_B1_수정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] list = new int[N];

        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(list);
//        System.out.println(Arrays.toString(list));

        for(int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
