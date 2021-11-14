// #모의고사_2

import java.util.*;
import java.lang.Math;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<Integer>();
        
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int size1 = 5;
        int size2 = 8;
        int size3 = 10;
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == p1[i%size1]) score1++;
            if(answers[i] == p2[i%size2]) score2++;
            if(answers[i] == p3[i%size3]) score3++;
        }
        
        int maxScore = Math.max(score1, Math.max(score2, score3));
        if(maxScore == score1) answer.add(1);
        if(maxScore == score2) answer.add(2);
        if(maxScore == score3) answer.add(3);
        
        return answer;
    }
}