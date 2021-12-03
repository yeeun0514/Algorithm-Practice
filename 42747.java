import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int HIndex = 0;
        
        Arrays.sort(citations);
        
        int index = 0;
        boolean check = true;
        while(check){
            for(int i=0; i<citations.length; i++){
                if(citations[i]>=index && citations.length - i >= index){
                    HIndex = index;
                    break;
                }else if(citations[i]>=index && citations.length - i < index){
                    check = false;
                    break;
                }
            }
            index++;
            if(index > citations[citations.length-1]){
                break;
            }
        }
        
        return HIndex;
    }
}