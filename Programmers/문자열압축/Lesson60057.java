package 문자열압축;

import java.util.PriorityQueue;

public class Lesson60057 {

	public static void main(String[] args) {
//		String s = "abcabcabcabcdededededede"; // 14
//		String s = "xababcdcdababcdcd"; // 17
		String s = "a";
		int answer = 0;
		
		Solution sol = new Solution();
		answer = sol.solution(s);
		System.out.println("answer : " + answer);
	}

}

class Solution {
    public int solution(String s) {
        int answer = 0;
        int sLength = s.length();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(sLength);
        
        for(int i=1; i<=sLength/2; i++){
        	pq.add(compressStr(s, i));
        }
        
        answer = pq.peek();
        
        return answer;
    }
    
    public int compressStr(String s, int length){
    	int answer = 0;
    	int index = length;
    	int count = 1;
    	String str = "";
    	String temp = s.substring(0, length);
    	
    	
    	while(index + length<=s.length()){
//    		System.out.println("index : " + index + ", last index : " + (index + length) + ", subStr : " + s.substring(index, index+length));
    		if(temp.equals(s.substring(index, index+length))){
//    			System.out.println("같다!!");
    			index += length;
    			count++;
    		}else{
    			if(count > 1){
    				str = str + Integer.toString(count) + temp;
    			}else{
    				str += temp;
    			}
    			temp = s.substring(index, index+length);
    			index += length;
    			count = 1;
    		}
    	}
    	
    	if(count > 1){
			str = str + Integer.toString(count) + temp;
		}else{
			str += temp;
		}
    	
    	if(index + length > s.length()){
    		str += s.substring(index);
    	}
    	
//    	System.out.println(length + " str : " + str);
    	answer = str.length();
    	
    	return answer;
    }
}