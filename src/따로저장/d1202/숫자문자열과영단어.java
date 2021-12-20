package 따로저장.d1202;

import java.util.Arrays;

public class 숫자문자열과영단어 {

    public static void main(String[] args) {
//        String s = "one4seveneight";
//
//        s = s.replace("zero", "0");
//        s = s.replace("one", "1");
//        s = s.replace("two", "2");
//        s = s.replace("three", "3");
//        s = s.replace("four", "4");
//        s = s.replace("five", "5");
//        s = s.replace("six", "6");
//        s = s.replace("seven", "7");
//        s = s.replace("eight", "8");
//        s = s.replace("nine", "9");
//
//        System.out.println(s);

    int n = 6;
     int[] arr1 = {46, 33, 33 ,22, 31, 50}
        ;
     int[] arr2 = {27 ,56, 19, 14, 14, 10}
        ;


        String[] s = new String[n];

        for(int i = 0; i < n; i++) {
            s[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            int t = n - s[i].length();
            if(s[i].length() != n) {
                for(int j = 0; j < t; j++) {
                    s[i] = "0" + s[i];
                }
            }


        }

        for(int i = 0; i < s.length; i++) {
            System.out.println(s[i]);

        }


        String[] answer = new String[n];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = "";
        }

        for(int i = 0; i < s.length; i++) {
            for(int j = 0; j < s[i].length(); j++) {
                if(s[i].charAt(j) == '0') {
                    answer[i] += " ";
                }else if(s[i].charAt(j) == '1'){
                    answer[i] += "#";
                }
            }
        }
        System.out.println(s[5]);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
        System.out.println(answer[3]);
        System.out.println(Arrays.toString(answer));






    }


}

/*
    [######, ###  #, ##  ##,  #### ,  #####, ### # ]
    [######, ###  #, ##  ##, #### , #####, ### # ]
 */
