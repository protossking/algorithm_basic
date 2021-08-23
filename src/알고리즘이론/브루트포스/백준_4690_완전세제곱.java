package 알고리즘이론.브루트포스;

public class 백준_4690_완전세제곱 {

    public static void main(String[] args) {


        for(int a = 6; a <=100; a++) {
            for(int b = 2; b< a; b++) {
                for(int c = b; c < a; c++) {
                    for(int d = c; d < a; d++) {
                        if ((a*a*a) == (d*d*d) + (c*c*c) + (b*b*b)){
                            System.out.printf("Cube = %d, Triple = (%d,%d,%d)\n",a,b,c,d);
                        }
                    }
                }
            }
        }
    }
}
