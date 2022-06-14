package 키패드누르기;

public class Lesson67256 {

	public static void main(String[] args) {
//		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		Solution s = new Solution();
		String answer = s.solution(numbers, hand);
		
		System.out.println(answer);
//		System.out.println(answer.equals("LRLLLRLLRRL"));
		System.out.println(answer.equals("LRLLRRLLLRR"));
	}

}

/*
 *		[1] [2] [3]
 * [0]	1	2	3
 * [1]	4	5	6
 * [2]	7	8	9
 * [3]	*	0	#
 * 
 */

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int rPosition = 3;
        int rCenterCheck = 3;
        int lPosition = 1;
        int lCenterCheck = 3;
        
        for(int i=0; i<numbers.length; i++){
        	int num = numbers[i];
        	int yPosition = 3;
        	int xPosition = 2;
        	
        	if(num != 0){
        		yPosition = num/3; // 0, 1, 2, 3
        		xPosition = num%3; // 1: Left 2: Center 0: Right
        	}
        	
        	if(xPosition == 0){
        		yPosition--;
        		xPosition = 3; // 1: Left 2: Center 3: Right
        	}
        	
        	if(xPosition == 1){
        		lPosition = xPosition;
        		lCenterCheck = yPosition;
        		answer += "L";
        	}else if(xPosition == 3){
        		rPosition = xPosition;
        		rCenterCheck = yPosition;
        		answer += "R";
        	}else{
        		if(Math.abs(xPosition - rPosition) + Math.abs(yPosition - rCenterCheck) > Math.abs(xPosition - lPosition) + Math.abs(yPosition - lCenterCheck)){
        			// Left Hand
        			lPosition = xPosition;
            		lCenterCheck = yPosition;
            		answer += "L";
        		}else if(Math.abs(xPosition - rPosition) + Math.abs(yPosition - rCenterCheck) < Math.abs(xPosition - lPosition) + Math.abs(yPosition - lCenterCheck)){
        			// Right Hand
        			rPosition = xPosition;
            		rCenterCheck = yPosition;
            		answer += "R";
        		}else {
        			if(hand.equals("right")){
        				// Right Hand
        				rPosition = xPosition;
                		rCenterCheck = yPosition;
                		answer += "R";
        			}else{
        				// Left Hand
        				lPosition = xPosition;
                		lCenterCheck = yPosition;
                		answer += "L";
        			}
        		}
        	}
        	
        }
        
        return answer;
    }
}
