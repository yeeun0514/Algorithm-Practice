import java.util.ArrayList;
import java.util.Arrays;

public class 87377 {

	public static void main(String[] args) {
		int[][] question = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		Solution s = new Solution();
		s.solution(question);
	}
	
}

class Point {
	long x, y;
	Point(long x, long y){
		this.x = x;
		this.y = y;
	}
}

class Solution {
    public String[] solution(int[][] line) {
        ArrayList<Point> points = new ArrayList<>();
        long minX=Long.MAX_VALUE;
        long minY=Long.MAX_VALUE;
        long maxX=Long.MIN_VALUE;
        long maxY=Long.MIN_VALUE;
        
        for(int i=0; i<line.length-1; i++) {
        	long a = line[i][0];
        	long b = line[i][1];
        	long e = line[i][2];
        	for(int j=i+1; j<line.length; j++ ) {
        		long c = line[j][0];
        		long d = line[j][1];
        		long f = line[j][2];
        		
        		long demo = a*d - b*c;
        		if(demo == 0) continue;
        		long numeratorX = b*f - e*d;
        		long numeratorY = e*c - a*f;
        		
        		if(numeratorX % demo != 0 || numeratorY % demo != 0) continue; 
        		
        		long x = numeratorX / demo;
        		long y = numeratorY / demo;
        		
        		points.add(new Point(x, y));
        		
    			minX = Math.min(minX, x);
    			maxX = Math.max(maxX, x);
    			minY = Math.min(minY, y);
    			maxY = Math.max(maxY, y);
        	}
        }
        
        points = setPoints(points, minX, maxY);
        
        long xLength = maxX - minX + 1;
        long yLength = maxY - minY + 1;
        String[] answer = new String[(int) yLength];
        
        for(int i=0; i<yLength; i++) {
        	answer[i] = getStars(points, i, xLength);
        	System.out.println(answer[i]);
        }
        
        
        return answer;
    }
    
    public ArrayList<Point> setPoints(ArrayList<Point> points, long minX, long maxY){
    	for(int i=0; i<points.size(); i++) {
    		Point temp = points.get(i);
    		temp.x = temp.x - minX;
    		temp.y = maxY - temp.y;
    		points.set(i, temp);
    		
    	}
    	
    	return points;
    }
    
    public String getStars(ArrayList<Point> points, int y, long xLength) {
		String[] answer = new String[(int) xLength];
		Arrays.fill(answer, ".");
		StringBuffer sb = new StringBuffer();
    	for(int i=0; i<points.size(); i++) {
    		Point temp = points.get(i);
    		if(temp.y == y) {
    			answer[(int) temp.x] = "*";
    		}
    	}
    	for(String v : answer) {
    		sb.append(v);
    	}
    	
    	return sb.toString();
    }
}