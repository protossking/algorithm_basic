package combination;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea9229_한빈이2 {
}


/*
package com.yang.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Solution {
    static int[] snack;
    static int[] selected;
    static int answer;
    static int M;
    static int N;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input9229.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        StringTokenizer st;
        for(int tc=1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine(), " ");
            snack = new int[N];
            for(int i = 0; i < N; i++) {
                snack[i] = Integer.parseInt(st.nextToken());
            }
            answer = -1;
            combination(0,0, 0);
            System.out.println(answer);

//            for(int i = 0; i < N-1; i++) {
//                for(int j = i+1; j < N; j++) {
//                    sum =  snack[i] + snack[j];
//                    if(sum <= M & max < sum) max = sum;
//                }
//            }



//            if(max == 0) System.out.println(-1);
//            System.out.println(tc + " " + max);
        }

    }
    static void combination(int cnt, int start, int total) { //cnt 는 자릿수 start 는 배열내 시작 위치
        if(total > M) {
            return;
        }
        if(cnt == 2) {
            if(answer < total) {
                answer = total;
                return;
            }
        }
        if(start == N) return;
        combination(cnt+1, start+1, total + snack[start]);

    }
}








 */