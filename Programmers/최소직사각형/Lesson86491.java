package 최소직사각형;

public class Lesson86491 {

	public static void main(String[] args) {
//		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
		Solution s = new Solution();
		System.out.println(s.solution(sizes));
	}

}

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 1;
        int height = 1;
        
        for(int i=0; i<sizes.length; i++){
//        	int w = Math.max(sizes[i][0], sizes[i][1]);
//        	int h = Math.min(sizes[i][0], sizes[i][1]);
        	
        	width = Math.max(Math.max(sizes[i][0], sizes[i][1]), width);
        	height = Math.max(Math.min(sizes[i][0], sizes[i][1]), height);
        	
        }
        
        answer = width * height;
        
        return answer;
    }
}