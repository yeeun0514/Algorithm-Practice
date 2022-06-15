package 멀쩡한사각형;

public class Lesson62048 {

	public static void main(String[] args) {
		int w = 4;
		int h = 3;
		Solution s = new Solution();
		System.out.println(s.solution(w, h));
	}

}

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        
        for(int x=1; x<w; x++){
        	int hLimit = (int) Math.floor(-1.0*h*x/w + h*1.0);
        	answer += hLimit;
        }
        
        return answer*2;
    }
}
