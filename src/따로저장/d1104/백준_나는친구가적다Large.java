package 따로저장.d1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 라빈 카프 알고리즘
public class 백준_나는친구가적다Large {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine().replaceAll("[0-9]", "");
        String k = in.readLine();

        if(findString(s, k)) {
            System.out.println("1");
        }else {
            System.out.println("0");
        }

    }

    static boolean findString(String e, String k) {

//        int MOD = 100000007;
        int eSize = e.length();
        int kSize = k.length();

        long eHash = 0;
        long kHash = 0;
        long power = 1;

        for(int i = 0; i <= eSize - kSize; i++) {
            if(i == 0) {
                for(int j = 0; j < kSize; j++) {
                    eHash = (eHash + (e.charAt(kSize-1-j)) * power);
                    kHash = (kHash + (k.charAt(kSize-1-j)) * power);
                    if(j < kSize -1) {
                        power = (power * 5) ;
                    }
                }
            }
            else {
                eHash = 5 * eHash - 5 *e.charAt(i-1)*power + e.charAt(i+kSize-1);

            }
            if(eHash == kHash) {

                if(eHash == kHash) {
                    boolean isFind = true;
                    for(int j = 0; j < kSize; j++) {
                        if(e.charAt(i+j) != k.charAt(j)) {
                            isFind = false;
                            break;
                        }
                    }

                    if(isFind) {
                        return true;
                    }
                }

            }


        }
        return false;

    }


}



