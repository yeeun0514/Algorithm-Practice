import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<Integer>();
        int workDay = 0;
        
        for(int i=0; i<progresses.length; i++){
            int days = (100 - progresses[i])/speeds[i];
            if((100 - progresses[i])%speeds[i] != 0){
                days++;
            }
            queue.add(days);
        }
        
        while(queue.size()>0){
            int workCount = 0;
            while(!queue.isEmpty() && queue.peek() <= workDay){
                workCount++;
                queue.remove();
            }
            if(workCount!=0){
                result.add(workCount);
            }
            workDay++;
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}