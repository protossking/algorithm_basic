package 따로저장.d1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1152_단어의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine();
        String aa = a.trim();
        String[] s = aa.split(" ");



        if(s.length == 1 && s[0].equals("")) {
            System.out.println("0");
        }else {
            System.out.println(s.length);
        }



    }
}
