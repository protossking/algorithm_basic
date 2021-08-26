package 스터디.d0825;

import java.util.Scanner;

public class 백준_2941_크로아티아알파벳 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] cro = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int cnt = 0;
        for (int i = 0; i < cro.length; i++) {

            if (s.contains(cro[i])) {
                s = s.replaceFirst(cro[i], "-");


                cnt++;
                i = -1;
            }
        }
        System.out.println(s);
        s = s.replaceAll("-", "");
        cnt += s.length();
        System.out.println(s);
        System.out.println(cnt);
    }
}