package 알고리즘이론.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1526_가장큰금민수 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        int max = Integer.MIN_VALUE;
        int i = 0;
        while (i <= N) {
            boolean check = false;
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '7' || s.charAt(j) == '4') {
                    check = true;
                }
                else {
                    check = false;
                    break;

                }


            }
            if(check == true){
                max = Math.max(max, i);
            }




            i++;
        }
        System.out.println(max);


    }
}
