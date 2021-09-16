package 알고리즘이론.디피;


import java.util.Scanner;

/*
    1. 가치가 큰 순서대로 담기
    2. 가벼운 순서대로 담기


    고려해야할 요소
    물건 , 물건으 ㅣ무게 물건의 가치 배낭의 용량 모두 4가지의 요소

    0-1 냅색

 */
public class DP1_Knapsack2 {

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
        int[] d = new int[W+1];

        for(int i = 1; i <= N; i++) {
            for(int w = W; w >= weights[i]; w--) {

                    d[w] = Math.max(d[w], profits[i] + d[w-weights[i]]);


            }
        }
        System.out.println(d[W]);
    }

}
