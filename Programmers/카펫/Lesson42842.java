package 카펫;

public class Lesson42842 {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		Solution s = new Solution();
		
		int[] answer = s.solution(brown, yellow);
		System.out.println(answer[0] + ", " + answer[1]);
	}

}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int b = (brown - 4)/2;
        for(int i=1; i< b; i++){
            if(i*(b-i) == yellow){
                if(b-i>=i){
                	answer[0] = b-i+2;
                	answer[1] = i+2;
                }else{
                	answer[0] = i+2;
                	answer[1] = b-i+2;
                }
                break;
            }
        }
        return answer;
    }
}