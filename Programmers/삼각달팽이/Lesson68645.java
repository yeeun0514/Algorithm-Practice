package 삼각달팽이;

import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int[][] triSnail = new int[n][n];
        
        int number = 0;
        int countNum = n;
        int course = 1;
        int x=0;
        int y=-1;
        
        while(countNum != 0) {
        	
        	for(int i=0; i<countNum; i++) {
        		if(course%3 == 1) {
        			y++;
        		}else if(course%3 == 2) {
        			x++;
        		}else {
        			x--;
        			y--;
        		}
        		number++;
        		triSnail[y][x] = number;
        	}
        	
    		countNum--;
    		course++;
        }
        
        answer = new int[number];
        int index=0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<i+1; j++) {
        		answer[index] = triSnail[i][j];
        		index++;
        	}
        }
        
        return answer;
    }
}