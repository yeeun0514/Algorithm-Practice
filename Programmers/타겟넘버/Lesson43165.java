package 타겟넘버;

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        int sum = 0;
        getDfs(numbers, sum + numbers[0], 0, target);
        getDfs(numbers, sum - numbers[0], 0, target);
        return answer;
    }
    
    public void getDfs(int[] numbers, int sum, int depth, int target){
        if(depth == numbers.length-1){
            if(sum == target){
                answer++;
            }
            return;
        }
        getDfs(numbers, sum + numbers[depth+1], depth+1, target);
        getDfs(numbers, sum - numbers[depth+1], depth+1, target);
        
    }
}