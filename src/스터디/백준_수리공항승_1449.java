package 스터디;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 백준_수리공항승_1449 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt(); // 테이프는 무한
        int[] water = new int[N];




        for(int i = 0; i <water.length; i++) {
            water[i] = sc.nextInt();
        }
        Arrays.sort(water);
        int count = 1;
        int idx = 0;
        for(int i = idx + 1; i <N;  i++) {
            if(water[idx] + L -1 < water[i]) {
                count ++;
                idx = i;
            }
        }
        System.out.println(count);








    }
}
