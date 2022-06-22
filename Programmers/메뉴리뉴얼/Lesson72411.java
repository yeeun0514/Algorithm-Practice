package 메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Lesson72411 {

	public static void main(String[] args) {
//		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//		String[] orders = {"AB", "ZC", "AC", "AC", "BC", "AD"};
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2, 3, 4};
		Solution s = new Solution();
		
		List<String> answer = s.solution(orders, course);
		
		System.out.println(answer);
	}

}
/*
 * order 별로 조합 묶음 만들면서 count
 */

class Solution {
	Map<String, Integer> courses = new HashMap<>();
    public List<String> solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> ansList = new ArrayList<>();
        List<Entry<String, Integer>> ans = new ArrayList<>();
        
        
        for(int i=0; i<orders.length; i++){
        	String[] menu = orders[i].split("");
        	
        	for(int j=0; j<course.length; j++){
        		if(menu.length<course[j]){
        			break;
        		}
        		Arrays.sort(menu);
        		dfs(menu, course[j], "", 0);
        	}
        	
        }
        
        ans = courses.entrySet().stream().filter(a -> a.getValue() >= 2).sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        
	     for(int i=0; i<course.length; i++){
	    	 int num = course[i];
	    	 int max = 0;
	    	 
	    	 for(int j=0; j<ans.size(); j++){
	    		 if(ans.get(j).getKey().length() == num && ans.get(j).getValue() >= max){
	    			 max = ans.get(j).getValue();
	    			 ansList.add(ans.get(j).getKey());
	    		 }else if(ans.get(j).getKey().length() == num && ans.get(j).getValue() < max){
	    			 break;
	    		 }
	    	 }
	     }
         
         Collections.sort(ansList);
        
        return ansList;
    }
    
    public void dfs(String[] menu, int courseNum, String course, int index){
    	if(course.length()==courseNum){
    		if(courses.containsKey(course)){
    			int temp = courses.get(course);
    			courses.replace(course, temp+1);
    		}else{    			
    			courses.put(course, 1);
    		}
    		return;
    	}
    	
    	for(int i = index; i<menu.length; i++){
    		if(course.contains(menu[i])){
    			continue;
    		}
    		dfs(menu, courseNum, course + menu[i], i + 1);
    	}
    	
    }
}