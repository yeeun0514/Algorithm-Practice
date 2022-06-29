package 더맵게;

import java.util.PriorityQueue;

public class Lesson42626 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		Solution s = new Solution();
		int answer = s.solution(scoville, K);
		
		System.out.println("answer : " + answer);
	}

}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville){
        	pq.add(i);
        }
        
        while(pq.peek()<K){
        	if(pq.size()<2){
        		answer = -1;
        		break;
        	}
        	int min1 = pq.poll();
        	int min2 = pq.poll();
        	
        	int newScovi = min1 + min2*2;
        	pq.add(newScovi);
        	answer++;
        }
        
        return answer;
    }
}

// 예전 풀이
class Solution2 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovs = new PriorityQueue<>();
        for(int s : scoville){
            scovs.add(s);
        }
        // scovs.sort((a, b) -> a-b);
        while(scovs.peek() < K){
            if(scovs.size() == 1){
                answer = -1;
                break;
            }
            int f1 = scovs.poll();
            int f2 = scovs.poll();
            int f_new = f1 + f2*2;
            scovs.add(f_new);
            answer++;
            // scovs.sort((a, b) -> a-b);
            
        }
        
        return answer;
    }
}


