package 알고리즘이론.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_세로읽기 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        char[][] c = new char[5][15];
        for (int i = 0; i < c.length; i++) {
            String s = in.readLine();
            for (int j = 0; j < s.length(); j++) {
                c[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (c[j][i] == ' ' || c[j][i] == '\0') {
                    continue;
                }
                sb.append(c[j][i]);
            }
        }
        System.out.println(sb);
    }


}







