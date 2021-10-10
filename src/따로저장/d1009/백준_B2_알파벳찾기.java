package 따로저장.d1009;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_B2_알파벳찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        StringBuilder sb = new StringBuilder();
        int[] c = new int[26];
        String ss = "abcdefghijklmnopqrstuvwxyz";



        for(int i = 0; i< ss.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if(ss.charAt(i) == s.charAt(j)) {
                    c[i] = j;
                    break;
                }else {
                    c[i] = -1;
                }
            }
        }

        for(int i = 0; i < c.length; i++) {
            System.out.print(c[i]+ " ");
        }


    }
}


/*



 */