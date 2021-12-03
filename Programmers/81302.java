class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {0, 0, 0, 0, 0};
        
        for(int i=0; i<5; i++){
            String[][] place = new String[5][5];
            for(int j=0; j<5; j++){
                place[j] = places[i][j].split("");
            }
            if(check(place)){
                answer[i] = 1;
            }
        }
        
        return answer;
    }
    
    public boolean check(String[][] place){
        for(int y=0; y<5; y++){
            for(int x=0; x<5; x++){
                if(place[y][x].equals("P")){
                    //바로 옆 확인
                    if(x<4 && place[y][x+1].equals("P")){
                        return false;
                    }
                    if(y<4 && place[y+1][x].equals("P")){
                        return false;
                    }
                    //두 칸 간격 확인
                    if(x<3 && place[y][x+2].equals("P") && place[y][x+1].equals("O")){
                        return false;
                    }
                    if(y<3 && place[y+2][x].equals("P") && place[y+1][x].equals("O")){
                        return false;
                    }
                    //대각선 확인
                    if(x>0 && y<4 && place[y+1][x-1].equals("P") && (place[y][x-1].equals("O") || place[y+1][x].equals("O"))){
                        return false;
                    }
                    if(x<4 && y<4 && place[y+1][x+1].equals("P") && (place[y][x+1].equals("O") || place[y+1][x].equals("O"))){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}