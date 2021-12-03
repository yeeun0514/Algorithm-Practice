package Programmers.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for(int i = progresses.length-1; i>=0; i--){
            stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
            
        }
        
        while(!stack.isEmpty()){
            int cnt = 1;
            int value = stack.pop();
            
            while(!stack.isEmpty() && stack.peek() <= value){
                cnt ++;
                stack.pop();
            }
            
            result.add(cnt);
            
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i< answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
        
    }
}