package 알고리즘이론.slindingwindow;


/*
    정수로 이루어진 배열에서 길이가 4인 서브 배열의 합계가 가장 큰 서브 배열의 합 ?
    시간복잡도 O(N*K)
 */
public class MaxSumArray_SW {

    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 10, 8, 4, 6, 5, 7, 1};

        int max = 0, sum = 0, k = 4;
        // 1. 윈도우(일정범위의요소 => k개 ) 의 요소를 원하는 방법으로 처리
        for(int i =0;  i < k; i++) {
            sum += nums[i];

        }
        // 2. 윈도우의 시작부분을빼고 윈도우 맨끝에 새 요소를 추가
        for(int i = 0, size = nums.length-k; i <size; i++) {
            sum-= nums[i]; // 윈도우에서 첫번째 요소를 빼기
            sum +=nums[i+k]; // 윈도우에서 새로운 요소 추가
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
