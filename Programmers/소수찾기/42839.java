import java.lang.Math;
import java.util.*;

class Solution {
    HashSet<Integer> prime = new HashSet<Integer>();
    public int solution(String numbers) {
        int answer = 0;
        String[] num = numbers.split("");
        
        getDfs(num, "", 0);
        
        answer = prime.size();
        
        return answer;
    }
    
    public void getDfs(String[] nums, String num, int depth){
        if(depth != 0){        	
        	if(checkNumber(Integer.parseInt(num))){
        		prime.add(Integer.parseInt(num));
        	}
        }
        
        // 끝까지 탐색했다면 break;
        if(depth == nums.length){
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!nums[i].equals("F")){
                String[] temp = nums.clone();
                temp[i] = "F";
                getDfs(temp, num + nums[i], depth + 1);
            }
        }
        
    }
    
    public boolean checkNumber(int num){
        if(num<2) return false;
        
        if(num == 2) return true;
        
        for(int i=2; i<= Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        
        return true;
    }
}