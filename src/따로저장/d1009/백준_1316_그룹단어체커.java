package 따로저장.d1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1316_그룹단어체커 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        int cnt = 0;
        for(int i = 0; i < T; i++) {
            String s = in.readLine();
            if(isContinue(s)) {
                cnt ++;
            }
        }
        System.out.println(cnt);

    }

    private static boolean isContinue(String s) {
        for(int i = 0; i < s.length() -1; i++) {
            char a = s.charAt(i);
            for(int j = i+1; j < s.length(); j++) {
                if(a != s.charAt(j)) {
                    for(int k = j+1; k < s.length(); k++) {
                        if(a == s.charAt(k)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}


/*
    첫번쨰 단어와 두번째부터 마지막까지 탐색
    그러다가 두번쨰 포문에서 다른숫자가 나올때 또 포문을 통해서 첫번쨰 단어가 나오면  연속이 깨짐
    그래서 false 리턴

 */