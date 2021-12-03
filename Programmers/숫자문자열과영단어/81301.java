package Programmers.숫자문자열과영단어;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<num.length; i++){
            if(s.contains(num[i])){
                s=s.replaceAll(num[i], Integer.toString(i));
            }
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}