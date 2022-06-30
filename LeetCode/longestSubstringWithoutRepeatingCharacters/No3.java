package longestSubstringWithoutRepeatingCharacters;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class No3 {

	public static void main(String[] args) {
		String str = "";
		
		Solution s = new Solution();
		
		System.out.println("answer : " + s.lengthOfLongestSubstring(str));
	}

}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        if(s.length()==0){
        	return answer;
        }
        String[] str = s.split("");
        Set<String> strSet = new HashSet<String>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<str.length; i++){
        	strSet.add(str[i]);
        	for(int j=i+1; j<str.length; j++){
        		if(!strSet.contains(str[j])){
        			strSet.add(str[j]);
        		}else{
        			break;
        		}
        	}
        	pq.add(strSet.size());
        	strSet.clear();
        	if(str.length-i+1<=pq.peek()){
        		break;
        	}
        }
        
    	answer = pq.peek();
        
        return answer;
    }
}
