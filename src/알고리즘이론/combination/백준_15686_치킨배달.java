package 알고리즘이론.combination;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준_15686_치킨배달 {
    static ArrayList<RC> house;
    static ArrayList<RC> chicken;
    static ArrayList<Integer> distance = new ArrayList<>(); // 각 거리
    static RC[] chickenCombi;
    static int[][] map;
    static int n;
    static int m;
    static int reuslt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 행렬크기
        m = sc.nextInt(); // 남겨야할 치킨집
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        chickenCombi = new RC[m];

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    house.add(new RC(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new RC(i, j));
                }
            }
        }

        combination(chicken.size(), m);
        System.out.println(reuslt);


    }

    static void combination(int n, int r) {
        if (r == 0) {
            dis();
            return;
        }
        if (n < r) return;
        chickenCombi[r - 1] = chicken.get(n - 1);
        combination(n - 1, r - 1);
        combination(n - 1, r);

    }

    static class RC {
        int r;
        int c;

        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void dis() {

        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int min = 2100000;
            for (int j = 0; j < chickenCombi.length; j++) {
                int r = house.get(i).r - chickenCombi[j].r ;
                int c = house.get(i).c - chickenCombi[j].c ;
                int a = Math.abs(r) + Math.abs(c);
//                sum += a;
                min = Math.min(min, a);
            }
            sum+= min;
            if(sum > reuslt) {
                return;
            }
        }
        reuslt = Math.min(sum, reuslt);



    }


}

