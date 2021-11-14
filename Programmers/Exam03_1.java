// #모의고사

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
		List <Object> winner = new ArrayList<Object>();
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		int win = 0;
		int[] a2 = { 1, 3, 4, 5 };
		int[] a3 = { 3, 1, 2, 4, 5 };
		int p1 = 0, p2 = 0, p3 = 0;

		for (int i = 0; i < answers.length; i++) {

			// 1번 (1, 2, 3, 4, 5)
			index1 = i % 5;
			if (answers[i] == (index1 + 1))
				p1++;

			// 2번
			index2 = (i % 8 - 1) / 2;
			if (i % 2 == 0) {
				if (answers[i] == 2)
					p2++;
			} else {
				if (answers[i] == a2[index2])
					p2++;
			}

			// 3번
			index3 = (i % 10) / 2;
			if (answers[i] == a3[index3])
				p3++;

		}
        
		win = Math.max(p1, p2);
		win = Math.max(win, p3);
		if(win==p1)
			winner.add(1);
		if(win==p2)
			winner.add(2);
		if(win==p3)
			winner.add(3);
		
		int[] w = new int [winner.size()];
		
		for(int i=0;i<winner.size();i++) {
			w[i]=(int) winner.get(i);
		}

		answer =w;
		return answer;
    }
}