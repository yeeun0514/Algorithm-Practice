package 신고결과받기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson92334 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//		String[] id_list = {"con", "ryan"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 2;
		
		Solution s = new Solution();
		int[] answer = s.solution(id_list, report, k);
		
		Arrays.stream(answer).forEach(System.out::println);
	}

}

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, User> users = new HashMap<>();
        
        List<String> reportList = Arrays.stream(report).distinct().collect(Collectors.toList());

        for(int i=0; i<id_list.length; i++){
        	User u = new User(id_list[i]);
        	users.put(id_list[i], u);
        }
        
        for(int i=0; i<reportList.size(); i++){
        	String[] r = reportList.get(i).split(" ");
        	users.get(r[1]).setConstraint();
        	users.get(r[1]).addNotifyList(r[0]);
        }
        
        for(int i=0; i<id_list.length; i++){
        	User u = users.get(id_list[i]);
        	if(u.getConstraint()>=k){
        		List<String> alertList = u.getNotifyList();
        		for(int j=0; j<alertList.size(); j++){
        			users.get(alertList.get(j)).setNotiCount();
        		}
        	}
        }
        
        for(int i=0; i<answer.length; i++){
        	answer[i] = users.get(id_list[i]).getNofiCount();
        }
        
        
        return answer;
    }
}

class User{
	String name;
	List<String> notifyList = new ArrayList<>();
	int notiCount = 0;
	int constraint = 0;
	
	User(String name){
		this.name = name;
	}
	
	public void addNotifyList(String id){
		this.notifyList.add(id);
	}
	
	public void setNotiCount(){
		this.notiCount++;
	}
	
	public void setConstraint(){
		this.constraint++;
	}
	
	public String getName(){
		return this.name;
	}
	
	public List<String> getNotifyList(){
		return this.notifyList;
	}
	
	public int getNofiCount(){
		return this.notiCount;
	}
	
	public int getConstraint(){
		return this.constraint;
	}
}