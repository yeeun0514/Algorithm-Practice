package addTwoNumbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class No2 {

	public static void main(String[] args) {
//		ListNode n1 = new ListNode(0);
//		ListNode n2 = new ListNode(9, n1);
//		ListNode n3 = new ListNode(9, n2);
//		ListNode n4 = new ListNode(9, n3);
//		ListNode n5 = new ListNode(9, n4);
//		ListNode n6 = new ListNode(9, n5);
//		ListNode n7 = new ListNode(9, n1);
		
//		ListNode m1 = new ListNode(0);
//		ListNode m2 = new ListNode(9, m1);
//		ListNode m3 = new ListNode(9, m2);
//		ListNode m4 = new ListNode(9, m1);
		
		
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4, n1);
		ListNode n3 = new ListNode(3, n2);
		
		ListNode m1 = new ListNode(5);
		ListNode m2 = new ListNode(6, m1);
		ListNode m3 = new ListNode(4, m2);
		
		Solution s = new Solution();
		s.addTwoNumbers(n3, m3);
	}

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = new ListNode();
        ListNode ln2 = new ListNode();
        
        BigInteger number1 = new BigInteger("0");
        BigInteger number2 = new BigInteger("0");
        BigInteger numberResult = new BigInteger("0");
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        boolean l1Check = true;
        boolean l2Check = true;
        
        ln1 = l1;
        ln2 = l2;
        
        while(l1Check || l2Check){
        	if(l1Check){        		
        		int lnVal1 = ln1.val;
        		list1.add(lnVal1);
        		
        		if(ln1.next == null){
        			l1Check = false;
        		}else{
        			ln1 = ln1.next;
        		}
        	}
        	
        	if(l2Check){
        		int lnVal2 = ln2.val;
        		list2.add(lnVal2);
        		
        		if(ln2.next == null){
        			l2Check = false;
        		}else{
        			ln2 = ln2.next;
        		}
        	}
        }
        
        for(int i=list1.size()-1; i>=0; i--){
        	BigInteger b1 = new BigInteger("10");
        	b1 = b1.pow(i);
        	b1 = b1.multiply(new BigInteger(list1.get(i).toString()));
        	number1 = number1.add(b1);
        }
        
        for(int i=list2.size()-1; i>=0; i--){
        	BigInteger b2 = new BigInteger("10");
        	b2 = b2.pow(i);
        	b2 = b2.multiply(new BigInteger(list2.get(i).toString()));
        	number2 = number2.add(b2);
        }
        
        numberResult = numberResult.add(number1);
        numberResult = numberResult.add(number2);
        
        String[] numResult = String.valueOf(numberResult).split("");
        
        ListNode answer = new ListNode(Integer.parseInt(numResult[0]));
        
        for(int i=1; i<numResult.length; i++){
        	ListNode temp = new ListNode(Integer.parseInt(numResult[i]), answer);
        	answer = temp;
        }
        
        return answer;
    }
}