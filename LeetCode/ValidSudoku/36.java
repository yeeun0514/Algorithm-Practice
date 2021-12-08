class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++){
            if(!check(board[i])){
                return false;
            }
            char[] checkColumn = {board[0][i], board[1][i], board[2][i], 
                            board[3][i], board[4][i], board[5][i],
                            board[6][i], board[7][i], board[8][i]};
            
            if(!check(checkColumn)){
                return false;
            }
            
            int x = i*3%9;
            int y = (i/3)*3;
            char[] checkBox = {board[y][x], board[y][x+1], board[y][x+2],
                          board[y+1][x], board[y+1][x+1], board[y+1][x+2],
                          board[y+2][x], board[y+2][x+1], board[y+2][x+2]};
           
            
            if(!check(checkBox)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean check(char[] check){
        int[] checkNum = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for(int i=0; i<9;i++){
            if(Character.compare(check[i], '.') == 0){
                continue;
            }else if(checkNum[Character.getNumericValue(check[i])] == 1){
                return false;
            }else if(checkNum[Character.getNumericValue(check[i])] == 0){
                checkNum[Character.getNumericValue(check[i])] = 1;
            }
        }
        return true;
    }
}