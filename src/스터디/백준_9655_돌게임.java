package 스터디;

import java.util.Scanner;

public class 백준_9655_돌게임 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        if(i % 2 ==1) {
            System.out.println("SK");
        }else {
            System.out.println("CK");
        }
    }

}
