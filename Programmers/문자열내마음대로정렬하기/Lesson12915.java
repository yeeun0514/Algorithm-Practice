package 문자열내마음대로정렬하기;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson12915 {

	public static void main(String[] args) {
		String[] wordArr = {"IronMan", "Captain", "Hulk", "Thor", "BlackPanther", "Spidey", "BlackWidow"};
		Solution s = new Solution();
		s.solution(wordArr, 1);
	}

}

class Solution {
    public List<String> solution(String[] strings, int n) {
        List<String> answer;
        
        List<Words> words = new ArrayList<>();
        for(String str : strings){
        	String[] iThArray = str.split("");
        	String iTh = iThArray[n];
        	Words w = new Words(str, iTh);
        	words.add(w);
        }
        
        answer = words.stream()
        		.sorted(Comparator.comparing(Words::getiThWord).thenComparing(Words::getWord))
        		.map(Words::getWord)
        		.peek(System.out::println)
        		.collect(Collectors.toList());
        
        return answer;
    }
}

class Words {
	String word;
	String iThWord;
	
	public Words(String word, String iThWord){
		this.word = word;
		this.iThWord = iThWord;
	}
	
	public String getWord() {
		return word;
	}
	public String getiThWord() {
		return iThWord;
	}
	
}