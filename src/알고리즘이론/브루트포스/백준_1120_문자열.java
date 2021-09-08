package 알고리즘이론.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1120_문자열 {

    static int ans;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        String a = st.nextToken();
        String b = st.nextToken();


        ans = a.length();

        for(int i = 0; i <= b.length()- a.length(); i++) {
            count = 0;
            for(int j = 0; j < a.length(); j++) {
                if(a.charAt(j) != b.charAt(i+j)) {
                    count ++;
                }
            }
            ans = Math.min(ans, count);
        }
        System.out.println(ans);



    }



}
