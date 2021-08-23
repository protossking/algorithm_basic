package 따로저장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_8958_계산기2 {

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new StringReader(src));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for(int tc = 1; tc <= T; tc ++) {
            int N = Integer.parseInt(in.readLine());
            Stack<Character> stack = new Stack<>();
            String input = in.readLine();
            String s ="";

            for(int i = 0; i < N; i++) {
                if(input.charAt(i)  != '+' && input.charAt(i) != '*'){
                    s += input.charAt(i);
                }
                else {
                    if(input.charAt(i) == '*') {
                        stack.push(input.charAt(i));
                    }
                    else {
                        do{
                            if(stack.isEmpty()) break;
                            s += stack.pop();
                        } while(!stack.isEmpty() && stack.peek() != '+');
                        stack.push(input.charAt(i));


                    }
                }
            }
            while(!stack.isEmpty()) {
                s += stack.pop();
            }
            Stack <Integer> result = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != '+' && s.charAt(i) != '*') {
                    result.push(s.charAt(i) -'0');
                }
                else {
                    int num1 = result.pop();
                    int num2 = result.pop();
                    char op = s.charAt(i);
                    switch (op) {
                        case '*':
                            result.push(num1 * num2);
                            break;
                        case '+':
                            result.push(num1 + num2);
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, result.peek());
        }

    }


    static String src = "101\n" +
            "9+5*2+1+3*3*7*6*9*1*7+1+8*6+6*1*1*5*2*4*7+4*3*8*2*6+7*8*4*5+3+7+2+6+5+1+7+6+7*3*6+2+6+6*2+4+2*2+4*9*3\n" +
            "79\n" +
            "4+4*3*4*9+2+7*4*7+7*7*9*5*2+8*8+2*6*7*3*7*9*3*4+8+8*9+3+9+6+9+4*1+6*3+5+1+7+5*1\n" +
            "113\n" +
            "2+3+9*9+8+2*1+3*2*3*1+3*3+1+2+3*6*2*7*4+9+1+4+6+9*9*5+7+8+6+3+9*2+1+7+4+3+9*3*1+4*4+4*3*1+9*3+9*5*1*7*8+2+8+8*7+9\n" +
            "89\n" +
            "4*9+1+1*8+8*9*7+1*4*5*2*5+8*3*5+5+2*4+2+8+6*2*2+9+3*1*2+2*5+9*2*3*9+6+7*9+9*4+7+6+6*6+3+8\n" +
            "77\n" +
            "5+4+9+9*9*2+6*6*5+9+3*5+5*7*8*3*7*1*9*9+8+3+8*9*6+2*9*3+6*5+6*7*2+5+5*3+4*6+7\n" +
            "119\n" +
            "5+7+1+6+3+6*7+7+5*5*3*5*6*9+5*9*5*9+8+8+5*1*6*2+3+2+8+6+2+2*3*4+5*8*3*6*2*9+1*7*7*4*2+2*5+6+7+2*7*4+9*6*4*3*1*3*5+3*7+8\n" +
            "115\n" +
            "8*6+3*9*8*7*6*3+5*7*6*6+3*5+2*4*9*3+5+2+1*4*1*7+6*8+9+3+2+8*3+8*2+6*9+2*2*7+8*1*2+9*3+1+5*5*8+4*1*2*4*2*6*3*8*8+4+1\n" +
            "91\n" +
            "5*8*4+5*7+9*2+6+5*7+1*7*9+8+6*1*2+7+5*9*6*3+4*8*9*6*1*3+7*1+2+5+1*4*9+6*4+7*1*2*4*2+3+3*4+9\n" +
            "107\n" +
            "7*1+7+5+3*7*1*7+8*3*8+7+3*2*6*2+3+6*4+3+8+9*4+1+5*7*8+9+1+2+5+6*7+4*5*2+4+8*4+7+9*1*3*1+1*2*8+3+2+9*1*5*9+7\n" +
            "109\n" +
            "1+1+7+3*2+1+3*7*8+9*6+1+8*3*7+8*5*7*7+4*3*7*4+7+3+2*2+7+8*8*6+6*6*7+7*1*5*7+3+1*5+1*8*4+9+6+7*5+3+1*8*8*9+4+7\n";
}
