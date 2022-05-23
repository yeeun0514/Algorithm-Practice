package 행렬테두리회전하기;

import java.util.PriorityQueue;

class Solution {
    int[][] query;
    
    public int[] solution(int rows, int columns, int[][] queries) {
    	int[] answer = new int[queries.length];
    	makeQueries(rows, columns);
        for(int i=0; i<queries.length; i++){
            answer[i]=circle(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        
        return answer;
    }
    
    public void makeQueries(int r, int c){
        query = new int[r+1][c+1];
        int count = 1;
        for(int i = 1; i<=r; i++){
            for(int j=1; j<=c; j++){
                query[i][j] = count;
                count++;
            }
        }
    }
    
    public int circle(int x1, int y1, int x2, int y2){
        int temp = 0;
        int temp2 = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=y1; i<=y2; i++) {
        	temp2 = query[x1][i];
        	query[x1][i] = temp;
        	pq.offer(temp);
        	temp = temp2;
        }
        for(int i=x1+1; i<=x2; i++) {
        	temp2 = query[i][y2];
        	query[i][y2] = temp;
        	pq.offer(temp);
        	temp = temp2;
        }
        for(int i=y2-1; i>=y1; i--) {
        	temp2 = query[x2][i];
        	query[x2][i] = temp;
        	pq.offer(temp);
        	temp = temp2;
        }
        for(int i=x2-1; i>= x1; i--) {
        	temp2 = query[i][y1];
        	query[i][y1] = temp;
        	pq.offer(temp);
        	temp = temp2;
        }
        pq.poll();
        return pq.poll();
    }
}