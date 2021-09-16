package 알고리즘이론.디피;


import java.util.Scanner;

/*
    1. 가치가 큰 순서대로 담기
    2. 가벼운 순서대로 담기


    고려해야할 요소
    물건 , 물건으 ㅣ무게 물건의 가치 배낭의 용량 모두 4가지의 요소

    0-1 냅색

 */
public class DP1_Knapsack {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();

        int[] weights = new int[N+1];
        int[] profits = new int[N+1];

        for(int i = 1; i <= N; i++) {
            weights[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }
        int[][] d = new int[N+1][W+1];

        for(int i = 1; i <= N; i++) {
            for(int w = 0; w <= W; w++) {
                if(weights[i] <= w) { // 해당 물건을 가방에 넣을수 있다.
                    d[i][w] = Math.max(d[i-1][w], profits[i] + d[i-1][w-weights[i]]);

                } else { // 해당물건을 가방에 넣을 수 없다.
                    d[i][w] = d[i-1][w];

                }
            }
        }
        System.out.println(d[N][W]);
    }

}
