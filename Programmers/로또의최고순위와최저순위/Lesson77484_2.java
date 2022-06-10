package 로또의최고순위와최저순위;

import java.util.Arrays;
import java.util.stream.IntStream;
/**
 * Stream을 이용한 풀이
 * 배열 합친 뒤 0제거, 중복 제거 하여 정답 갯수 구함
 *
 */

public class Lesson77484_2 {

	public static void main(String[] args) {
		int[] lottos = {1, 2, 0, 0, 0, 3};
		int[] win_nums = {1, 2, 3, 5, 6, 7};
		
		Solution_2 s2 = new Solution_2();
		int[] answer = s2.solution(lottos, win_nums);
		System.out.println(answer[0] + ", " + answer[1]);
		
	}

}

class Solution_2 {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int zeroCount = (int) Arrays.stream(lottos).filter(s -> s == 0).count();
		
		int merge = (int) IntStream.concat(IntStream.of(lottos), IntStream.of(win_nums)).filter(s -> s > 0).distinct().count();
		
		int correctCount = 12 - zeroCount - merge;
		
		int maxGrade = 7 - (correctCount + zeroCount);
		int minGrade = 7 - correctCount;
		
		if(maxGrade == 7){
			maxGrade = 6;
		}
		
		if(minGrade == 7){
			minGrade = 6;
		}
		
		answer[0] = maxGrade;
		answer[1] = minGrade;
		
		return answer;
	}
}
