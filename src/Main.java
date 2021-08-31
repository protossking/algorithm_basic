import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] nums;
    static boolean tag;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        nums = new int[7];
        tag = false;
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(in.readLine());

        }
        combi(0,0,0);



    }
    static void combi(int cnt, int start, int sum) {
        if(cnt == 7) {
            if(sum == 100) {
                tag = true;
                Arrays.sort(nums);
                for(int num: nums) {
                    System.out.println(num);import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

                    public class Main {
                        static int[] arr;
                        static int[] nums;
                        static boolean tag;
                        public static void main(String[] args) throws IOException {
                            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                            arr = new int[9];
                            nums = new int[7];
                            tag = false;
                            for(int i = 0; i < 9; i++) {
                                arr[i] = Integer.parseInt(in.readLine());

                            }
                            combi(0,0,0);



                        }
                        static void combi(int cnt, int start, int sum) {
                            if(cnt == 7) {
                                if(sum == 100) {
                                    tag = true;
                                    Arrays.sort(nums);
                                    for(int num: nums) {
                                        System.out.println(num);
                                    }


                                }
                                return;
                            }
                            if(sum > 100) {
                                return;
                            }

                            for(int i = start; i < arr.length; i++) {
                                if(tag == true) {
                                    return;
                                }
                                nums[cnt] = arr[i];
                                combi(cnt + 1, i+1, sum + nums[cnt]);
                                combi(cnt, i+1, sum);

                            }
                        }

                    }
                }


            }
            return;
        }
        if(sum > 100) {
            return;
        }

        for(int i = start; i < arr.length; i++) {
            if(tag == true) {
                return;
            }
            nums[cnt] = arr[i];
            combi(cnt + 1, i+1, sum + nums[cnt]);
            combi(cnt, i+1, sum);

        }
    }

}