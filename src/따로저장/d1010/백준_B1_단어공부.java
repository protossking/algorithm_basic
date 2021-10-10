package 따로저장.d1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class 백준_B1_단어공부 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine().toUpperCase();
        String al = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] list = new int[26];
        for(int i = 0; i < s.length(); i++) {
            list[s.charAt(i) -'A']++;
        }
//        System.out.println(Arrays.toString(list));
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < list.length; i++) {
            if(list[i] > max) {
                max = list[i];
                index = i;
            }
        }
        int count = 0;
        for(int i = 0; i < list.length; i++) {
            if(list[i] == max) {
                count ++;
            }
        }
        if(count == 1) {
            System.out.println(al.charAt(index));

        }else {
            System.out.println("?");
        }


        System.out.println('?' -'A');
        System.out.println('?' +'A');
        System.out.println((char)(128 + 'A'));
    }
}


/*
 char[] 로 바꾸고 list[26] 만들어서 ++ 해줌
 그리고 max 값을 찾아서 Collections.max 해서 구한다음 list 돌면서 max 값이 두개이상이면 ? 출력
 아니면 그 알파벳출력
 */