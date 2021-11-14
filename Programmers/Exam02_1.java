// #k번째수_1

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int[] ans= new int[commands.length];
        int i, j, k, z;
        
        for(int a=0;a<commands.length;a++) {
        	
        	i=commands[a][0];
        	j=commands[a][1];
        	k=commands[a][2];
        	
        	int s=j-i+1;
        	int p=i-1;
        	
        	int[] arr = new int [s];
        	
        	for(int b=0;b<s;b++) {
        		arr[b]=array[p];
        		p++;
        	}
        	
        	Arrays.sort(arr);
        	ans[a]=arr[k-1];
        	
        }
        answer=ans;
        
        return answer;
    }
}