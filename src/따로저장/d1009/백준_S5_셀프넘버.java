package 따로저장.d1009;

public class 백준_S5_셀프넘버 {

    public static void main(String[] args) {

        int n  = 1;
        boolean[] list = new boolean[1000000];
        while (n<10000) {

            int t = d(n);
            list[t] = true;
            //생성자 만들기 함수 1~만 까지 포문 돌릴때 57은 51을 d(n)을 해서 생긴것  n 부터 만까지 d(n) 에서 나온 결과값을
            // 배열 자리에 저장

            n++;
        }

        for(int i = 1; i < 10000; i++) {
            if(list[i] == false) {
                System.out.println(i);
            }
        }
    }

    static int d(int n) {
        String s = Integer.toString(n);
        int a = n;
        for(int i = 0; i < s.length(); i++) {
            a += s.charAt(i)-'0';
        }
        return a;

    }
}



/*
a 에서 연산해서 b 가 나오면 a는 b 의 생산자
생성자가 없는 숫자를 셀프넘버


 */