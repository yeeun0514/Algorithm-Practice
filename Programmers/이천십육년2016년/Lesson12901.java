package 이천십육년2016년;

public class Lesson12901 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(3, 1));
	}
}

class Solution {
  public String solution(int a, int b) {
     String answer = "";
		
	int m=a;
	int d=0;
	int dw=0;
	
	switch(a) {
	case 12:
		d+=30;
	case 11:
		d+=31;
	case 10:
		d+=30;
	case 9:
		d+=31;
	case 8:
		d+=31;
	case 7:
		d+=30;
	case 6:
		d+=31;
	case 5:
		d+=30;
	case 4:
		d+=31;
	case 3:
		d+=29;
	case 2:
		d+=31; break;
	}
	
	d+=b;
	dw=d%7;
	
	switch(dw){
	case 1:
		answer="FRI"; break;
	case 2:
		answer="SAT"; break;
	case 3:
		answer="SUN"; break;
	case 4:
		answer="MON"; break;
	case 5:
		answer="TUE"; break;
	case 6:
		answer="WED"; break;
	default:
		answer="THU";
	}
	
	return answer;
  }
}
