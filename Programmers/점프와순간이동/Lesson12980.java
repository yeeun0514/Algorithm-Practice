package 점프와순간이동;

class Solution {
    public int solution(int n) {
        int ans = 0;
        while(true) {
        	if(n%2==1) {
        		n--;
        		ans++;
        	}else {
        		n = n/2;
        	}
        	if(n==0) {
        		break;
        	}
        }
        
        return ans;
    }
}