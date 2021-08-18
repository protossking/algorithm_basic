package 알고리즘이론.그리디;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 정올_1828_냉장고 {

    static class Temp implements Comparable<Temp>{
        int low;
        int high;

        public Temp(int low, int high) {
            this.low = low;
            this.high = high;
        }



        @Override
        public int compareTo(Temp t) {
            int value = this.high - t.high;
            if(value != 0) {
                return value;
            }
            return this.low - t.low;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Temp[] temps = new Temp[N];
        for(int i = 0; i < N; i++) {
            temps[i] = new Temp(sc.nextInt(), sc.nextInt());
        }
        System.out.println(get(temps));
    }
    static int get(Temp[] temps) {
        ArrayList<Temp> list = new ArrayList<Temp>();
        Arrays.sort(temps);
        list.add(temps[0]);
        int max = list.get(0).high;
        int cnt = 1;
        for(int i = 1 ; i < temps.length; i++) {
            if(max < temps[i].low) {
                max = temps[i].high;
                list.add(temps[i]);

            }
        }
        return list.size();
    }
}
