package 스터디;

import java.util.Scanner;

public class 백준_암호2_1718 {

    static String word = "abcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        StringBuilder sb = new StringBuilder();


//        System.out.println(word.indexOf(s.charAt(0)));
//        System.out.println(word.indexOf(p.charAt(0%p.length())));



        for(int i = 0; i < s.length(); i++) {
            if(word.indexOf(s.charAt(i)) - word.indexOf(p.charAt(i % p.length())) > 0) {
                int index = word.indexOf(s.charAt(i)) - word.indexOf(p.charAt(i%p.length()));
                sb.append(word.charAt(index-1));
            } else if (s.charAt(i) == ' ') {
                sb.append(" ");
            } else if (word.indexOf(s.charAt(i)) - word.indexOf(p.charAt(i % p.length())) < 0){
//                int index2 = word.length() - word.indexOf(p.charAt(i % p.length()));
                int tIndex = word.length() - word.indexOf(p.charAt(i % p.length()));
                int i1 = word.indexOf(s.charAt(i)) + tIndex;
                sb.append(word.charAt(i1-1));
            } else if(word.indexOf(s.charAt(i)) - word.indexOf(p.charAt(i % p.length())) == 0) {
                sb.append("z");
            }
        }
        System.out.println(sb.toString());


    }



}
