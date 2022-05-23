package 오픈채팅방;

import java.util.*;

class Solution {
    public static HashMap<String, String> user = new HashMap<String, String>();
    public String[] solution(String[] record) {
        
        Queue<Records> temp = new LinkedList<>();
        
        for(int i=0; i<record.length; i++){
            String[] info = record[i].split(" ");
            if(record[i].contains("Enter")){
                checkUid(info[1], info[2]);
                temp.add(new Records(info[1], "들어왔습니다."));
            }else if(record[i].contains("Leave")){
                temp.add(new Records(info[1], "나갔습니다."));
            }else if(record[i].contains("Change")){
                checkUid(info[1], info[2]);
            }
        }
        
        Records result = new Records();
        String[] answer = new String[temp.size()];
        int i =0;
        while(temp.peek() != null){
            result = temp.poll();
            String nickName = user.get(result.getUserId());
            answer[i] = nickName + "님이 " + result.getAction();
            i++;
        }
        return answer;
    }
    
    public void checkUid(String id, String name){
        if(user.containsKey(id)){
            user.replace(id, name);
        }else{
            user.put(id, name);
        }
    }
}

class Records {
    String userId;
    String action;
    
    public Records(){
        this.userId = null;
        this.action = null;
    }
    
    public Records(String uid, String ac){
        this.userId = uid;
        this.action = ac;
    }
    
    public String getUserId(){
        return userId;
    }
    
    public String getAction(){
        return action;
    }
}