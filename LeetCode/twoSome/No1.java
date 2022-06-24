package twoSome;

public class No1 {

	public static void main(String[] args) {
//		int[] nums = {2,7,11,15};
		int[] nums = {0, 4, 3, 0};
		int target = 0;
		
		Solution s = new Solution();
		int[] answer = s.twoSum(nums, target);
		
		System.out.println("["+answer[0] + "," + answer[1] + "]");
	}

}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        
        for(int i=0; i<nums.length-1; i++){
        	for(int j=i+1; j<nums.length; j++){
        		if(nums[i] + nums[j] == target){
        			answer[0] = i;
        			answer[1] = j;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}