package medianOfTwoSortedArrays;

import java.util.stream.IntStream;

public class No4 {

	public static void main(String[] args) {
//		int[] nums1 = {1, 3};
//		int[] nums2 = {2};
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		
		Solution s = new Solution();
		System.out.println("answer : " + s.findMedianSortedArrays(nums1, nums2));
	}

}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double answer = 0.0;
        
        int[] newNums = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).sorted().toArray();
        
        int nnLength = newNums.length;
        int index = nnLength/2;
        
        if(nnLength%2 == 0){
        	answer = (newNums[index-1] + newNums[index])/2.0;
        }else{
        	answer = newNums[index];
        }
        
        return answer;
    }
}