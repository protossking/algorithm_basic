package 알고리즘이론.slindingwindow;


/*
    정수로 이루어진 배열에서 길이가 4인 서브 배열의 합계가 가장 큰 서브 배열의 합 ?
 */
public class MaxSumArray1 {

    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 10, 8, 4, 6, 5, 7, 1};

        int max = 0, sum = 0, k = 4;

        for(int i =0, size = nums.length-k; i < size; i++) {
            sum = 0 ;
            for(int j = i, end = i+k; j < end; j++) {
                sum += nums[j];
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
