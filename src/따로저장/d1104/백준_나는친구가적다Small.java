package 따로저장.d1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_나는친구가적다Small {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String k = in.readLine();
        String s2 = "";

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                continue;
            }
            else if(s.charAt(i) == '2'){
                continue;
            }
            else if(s.charAt(i) == '3'){
                continue;
            }
            else if(s.charAt(i) == '4'){
                continue;
            }
            else if(s.charAt(i) == '5'){
                continue;
            }
            else if(s.charAt(i) == '6'){
                continue;
            }
            else if(s.charAt(i) == '7'){
                continue;
            }
            else if(s.charAt(i) == '8'){
                continue;
            }
            else if(s.charAt(i) == '9'){
                continue;
            }
            else if(s.charAt(i) == '0'){
                continue;
            }else {
                s2 += s.charAt(i);
            }

        }
//        System.out.println(s2);

        if(s2.contains(k)) {
            System.out.println("1");
        }else {
            System.out.println("0");
        }
    }
}
