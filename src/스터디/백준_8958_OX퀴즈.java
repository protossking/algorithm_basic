package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_8958_OX퀴즈 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int tc = 0; tc < T; tc++) {
            String s = in.readLine();
            int score = 0;
            int w = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'O') {
                    w++;
                    score = score + w;
                } else {
                    w = 0;
                }
            }
            System.out.println(score);

        }




    }
}
