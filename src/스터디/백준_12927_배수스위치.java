package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_12927_배수스위치 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        char[] input = new char[s.length() + 1];
        int cnt = 0;

        for (int i = 1; i < input.length; i++) {
            input[i] = s.charAt(i - 1);
        }


//        if (input[1] == 'Y') {
//            cnt++;
//            input[1] = 'N';
//
//        }
        for (int i = 1; i < input.length; i++) {
            if (input[i] == 'N') continue;
            for (int j = i + 1; j < input.length; j++) {
                if (j % i == 0 ) {
                    if(input[j] == 'Y'){
                        input[j] = 'N';
                    } else if(input[j] == 'N') {
                        input[j] = 'Y';
                    }

                }
            }
            cnt++;

        }
        System.out.println(cnt);


    }

}
