package 알고리즘이론.디피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1463_1로만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[] count = new int[N + 1];

        count[1] = 0;

        for (int i = 2; i < N + 1; i++) {
            count[i] = count[i-1] + 1;

            if (i % 2 == 0) {
                count[i] = Math.min(count[i], count[i / 2] + 1);
            }
            if (i % 3 == 0) {
                count[i] = Math.min(count[i], count[i / 3] + 1);
            }




        }

        System.out.println(count[N]);
    }

}
