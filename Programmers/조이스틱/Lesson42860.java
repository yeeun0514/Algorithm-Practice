package 조이스틱;

import java.util.PriorityQueue;

public class Lesson42860 {

	public static void main(String[] args) {
//		String name = "JAZ";
		String name = "JEROEN";
//		String name = "JAN";
//		String name = "JEERASGAN";
		
		Solution s = new Solution();
		System.out.println(s.solution(name));
	}

}

class Solution {
	PriorityQueue<Integer> score = new PriorityQueue<>();
	
	public int solution(String name) {
        int answer = 0;
        
        char[] names = name.toCharArray();
        int[] aCheck = new int[names.length];
        int indexSum = 0;
        
        for(int i=0; i<names.length; i++){
        	answer += countAlphabet(names[i]);
        	if(Character.compare(names[i], 'A') != 0){
        		aCheck[i] = 1;
        		indexSum += i;
        	}else{
        		aCheck[i] = 0;
        	}
        }
        
        answer += findPath(aCheck, indexSum);
        
        return answer;
    }
    
    public int countAlphabet(char n){
    	int count = 0;
    	char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    	
    	for(int i=0; i<alphabet.length; i++){
        	if(Character.compare(alphabet[i], n) == 0){
        		int fromFirst = i;
        		int fromLast = 26 - i;
        		count = Math.min(fromFirst, fromLast);
        		break;
        	}
        }
    	
    	return count;
    }
    
    public int findPath(int[] aPath, int indexSum){
    	int count = 0;
    	
    	countPath(aPath, 0, indexSum, 0);
    	
    	count = score.poll();
    	
    	return count;
    }
    
    public void countPath(int[] aPath, int index, int indexSum, int count){
    	if(indexSum == 0){
    		score.add(count);
    		return;
    	}
    	
    	int toRight=index;
    	int toLeft=index;
    	int rightCount=0;
    	int leftCount=0;
    	int indexCount=0;
    	boolean checkRight = true;
    	boolean checkLeft = true;
    	
    	
    	while(checkRight || checkLeft){
    		indexCount++;
    		if(indexCount == aPath.length){
    			break;
    		}
    		
    		if(checkRight){
    			toRight++;
    			rightCount++;
    			if(toRight >= aPath.length){
    				toRight = 0;
    			}
    		}
    		if(checkLeft){
    			toLeft--;
    			leftCount++;
    			if(toLeft<0){
    				toLeft = aPath.length - 1;
    			}
    		}
    		
    		if(aPath[toRight] == 1 && checkRight){
    			checkRight = false;
    		}
    		if(aPath[toLeft] == 1 && checkLeft){
    			checkLeft = false;
    		}
    		
    	}
    	
    	int[] rightPath = aPath.clone();
    	rightPath[toRight]++;
    	countPath(rightPath, toRight, indexSum - toRight, count + rightCount);
    	
    	int[] leftPath = aPath.clone();
    	leftPath[toLeft]++;
    	countPath(leftPath, toLeft, indexSum - toLeft, count + leftCount);
    	
    }
}