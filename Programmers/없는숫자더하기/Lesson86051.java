package 없는숫자더하기;

import java.util.Arrays;

public class Lesson86051 {

	public static void main(String[] args) {
		int[] num = {5,8,4,0,6,7,9};
		Solution s = new Solution();
		System.out.println(s.solution(num));
	}

}

class Solution {
	public int solution(int[] numbers) {
        int answer = -1;
        int sum = Arrays.stream(numbers).sum();
        answer = 45-sum;
        return answer;
    }
}
