package 카카오프렌즈컬러링북;

import java.util.Collections;
import java.util.PriorityQueue;

public class Lesson1829 {

	public static void main(String[] args) {
		int[][] picture = {{1, 1, 1, 0}, 
						   {1, 2, 2, 0}, 
						   {1, 0, 0, 1}, 
						   {0, 0, 0, 1}, 
						   {0, 0, 0, 3}, 
						   {0, 0, 0, 3}};
		int m = 6;
		int n = 4;
		
		Solution s = new Solution();
		int[] answer = s.solution(m, n, picture);
		System.out.println("[" + answer[0] + ", " + answer[1] + "]");
	}

}

class Solution {
	static int areaSize = 0;
	static int[][] pictureMap;
	static int width, height;
	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        pictureMap = new int[m][n];
        
        // 깊은 복사
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		pictureMap[i][j] = picture[i][j];
        	}
        }
        
        width = n;
        height = m;
        
        for(int i=0; i<height; i++){
        	for(int j=0; j<width; j++){
        		if(pictureMap[i][j] > 0){
        			numberOfArea++;
        			bfs(j, i, pictureMap[i][j]);
        			pq.add(areaSize);
        			areaSize=0;
        		}
        	}
        }
        
        maxSizeOfOneArea = pq.peek();

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void bfs(int xIndex, int yIndex, int areaValue){
    	if(pictureMap[yIndex][xIndex] == areaValue){
    		pictureMap[yIndex][xIndex] = -1;
    		areaSize++;
    		
    		// left
    		if(xIndex > 0){
    			bfs(xIndex-1, yIndex, areaValue);
    		}
    		// right
    		if(xIndex < width-1){
    			bfs(xIndex+1, yIndex, areaValue);
    		}
    		// down
    		if(yIndex < height-1){
    			bfs(xIndex, yIndex+1, areaValue);
    		}
    		// up
    		if(yIndex > 0){
    			bfs(xIndex, yIndex-1, areaValue);
    		}
    	}
    	
    	return;
    }
}