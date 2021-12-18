class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int findZero = 0;
        int findNum = 0;
        
        for(int i = 0 ; i < lottos.length; i++){
            if(lottos[i] == 0){
                findZero++;
                continue;
            }
            for(int j = 0; j<win_nums.length; j++){
                if(lottos[i] == -1) continue;
                if(lottos[i] == win_nums[j]){
                    findNum++;
                    lottos[i] = -1;
                    break;
                }
            }
        }
        
        int max = findZero + findNum;
        
        answer[0] = getWins(max);
        answer[1] = getWins(findNum);
        
        return answer;
    }
    
    public int getWins(int num){
        int ranking = 7 - num;
        if(ranking == 7){
            ranking = 6;
        }
        return ranking;
    }
}