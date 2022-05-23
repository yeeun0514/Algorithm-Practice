package 프린터;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Printer> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            q.add(new Printer(priorities[i], i));
        }
        
        while(!q.isEmpty()){
            Printer cur = q.poll();
            boolean check = false;
            for(Printer p : q){
                if(cur.prior<p.prior){
                    check = true;
                    break;
                }
            }
            
            if(check){
                q.add(cur);
            }else{
                if(cur.location == location){
                    answer = priorities.length - q.size();
                    break;
                }
            }
        }
        
        return answer;
    }
    
    class Printer {
        int prior;
        int location;
        
        Printer(int prior, int location){
            this.prior = prior;
            this.location = location;
        }
    }
}