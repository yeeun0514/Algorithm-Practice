package 후보키;

import java.util.Arrays;
import java.util.HashSet;

public class Lesson42890 {

	public static void main(String[] args) {
//		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
//		String[][] relation = {{"aa", "a"}, {"a", "aa"}, {"a", "aaa"}};
//		String[][] relation = {{"a","1","aaa","c","ng"},{"b","1","bbb","c","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}};
//		String[][] relation = {{"ab", "c"}, {"a", "bc"}, {"x", "yz"}, {"x", "c"}};
		String[][] relation = {
				{ "100","ryan","music","1", "a" },
		        { "100","ryan2","music","2", "b" },
		        { "100","ryan","music","3", "b" },
		        { "100","ryan3","music","4", "b" },
		        { "100","ryan","music","5", "c" },
		        { "100","ryan5","music","6", "b" }
		    }; // 2
		Solution s = new Solution();
		
		System.out.println(s.solution(relation));
	}

}

class Solution {
	HashSet<String> keySets = new HashSet<String>();
    public int solution(String[][] relation) {
        int answer = 0;
        String[] relationSet = new String[relation.length];
        for(int i=0; i<relation[0].length; i++){
        	dfs(relation, relationSet, "", 0, i+1);
        }
        answer = keySets.size();
        System.out.println(keySets);
        return answer;
    }
    
    public void dfs(String[][] relation, String[] relations, String keySet, int index, int max){
    	if(keySet.length() == max || index >= relation[0].length){
			if(checkDuplicate(relations)){
				keySets.add(keySet);
    		}
    		return;
    	}
    	
    	for(int i=index; i<relation[0].length; i++){
    		if(checkKeySets(keySet + String.valueOf(i))){  
    			continue;
    		}
    		String[] temp = relations.clone();
    		for(int j=0; j<relation.length; j++){
    			temp[j] += relation[j][i] + " ";
    		}
    		dfs(relation, temp, keySet + String.valueOf(i), i + 1, max);
    	}
    }
    
    public boolean checkDuplicate(String[] relations){
    	int dupLength = (int) Arrays.stream(relations).distinct().count();
    	
    	if(dupLength == relations.length){
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean checkKeySets(String keySet){
    	for(String str : keySets){
    		String[] atts = str.split("");
    		int count = 0;
    		for(String s : atts){
    			if(keySet.contains(s)){
    				count++;
    			}
    		}
    		if(atts.length == count){
    			return true;
    		}
    	}
    	return false;
    }
}