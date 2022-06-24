package 위장;
import java.util.*;

public class Lesson42578 {

	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		Solution s = new Solution();
		int answer = s.solution(clothes);
		System.out.println(answer);
	}

}

class Solution {
 public int solution(String[][] clothes) {
     int answer = 1;
     
     Map<String, Integer> map = new HashMap<String, Integer>();
     
     for(int i=0; i<clothes.length; i++){
         String key = clothes[i][1];
         if(map.containsKey(key)){
             map.put(key, map.get(key)+1);
         }else{
             map.put(key, 1);
         }
         
     }
     
     Iterator<Integer> keys = map.values().iterator();
     while(keys.hasNext()){
         
         answer *= keys.next().intValue()+1;
     }
     
     return answer-1;
 }
}