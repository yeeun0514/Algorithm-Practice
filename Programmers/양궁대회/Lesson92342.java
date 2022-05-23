package 양궁대회;

import java.util.Arrays;

class Solution {
	int arrow;
	int[] a_info;
	int[] answer = new int[11];
	boolean isPossible;
	int maxPoint=-1;
    public int[] solution(int n, int[] info) {
        arrow = n;
        a_info = info;
        play(new int[11], 0, 0, 0, 0);
        if(!isPossible) {
        	answer = new int[1];
        	answer[0] = -1;
        }
        return answer;
    }
    
    public void play(int[] r_info, int arrow_cnt, int idx, int a_point, int r_point) {
    	if(idx == 11) {
    		if(arrow_cnt < arrow) {
    			r_info[10] = arrow-arrow_cnt;
    		}
    		if(a_point<r_point) {
    			isPossible = true;
    			if(r_point-a_point > maxPoint) {
    				maxPoint = r_point-a_point;
    				answer = Arrays.copyOfRange(r_info, 0, 11);
    			}else if(r_point-a_point == maxPoint) {
    				checkAnswer(answer, r_info);
    			}
    		}
    		return;
    	}
    	
    	// 안쏘기
    	int apeach_point = a_info[idx]>0?10-idx : 0;
    	r_info[idx] = 0;
    	play(r_info, arrow_cnt, idx+1, a_point + apeach_point, r_point);
    	
    	// 쏘기
    	int ryan_arrow = a_info[idx] + 1;
    	int ryan_point = 10-idx;
    	if(ryan_arrow+arrow_cnt <= arrow) {
    		r_info[idx] = ryan_arrow;
    		play(r_info, ryan_arrow + arrow_cnt, idx + 1, a_point, r_point + ryan_point);
    	}
    	
    }
    
    public void checkAnswer(int[] old, int[] now) {
    	for(int i=10; i>=0; i--) {
    		if(old[i] < now[i]) {
    			answer = Arrays.copyOfRange(now, 0, 11);
    			return;
    		}else if(old[i] > now[i]){
    			return;
    		}
    	}
    	return;
    }
}
