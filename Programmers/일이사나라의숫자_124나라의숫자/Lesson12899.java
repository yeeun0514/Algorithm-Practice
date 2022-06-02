package 일이사나라의숫자_124나라의숫자;

import java.util.ArrayList;
import java.util.List;

public class Lesson12899 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(13));
	}

}

class Solution {
	public String solution(int n){
		String answer = "";
		List<String> str = new ArrayList<>();
		int quotient = n;
		int remainder;
		
		while(quotient>0){
			remainder = quotient % 3;
			quotient = quotient / 3;
			if(remainder != 0){
				str.add(0, Integer.toString(remainder));
			}else{
				str.add(0, "4");
				quotient--;
			}
			
		}
		
		answer = String.join("", str);
		
		return answer;
	}
}