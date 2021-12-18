import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public Object[] solution(String[] genres, int[] plays) {
Object[] answer;
        List<Integer> ans = new ArrayList<Integer>();
        Map<String, Integer> genre = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
        	genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> gSet = new ArrayList<>(genre.keySet());
        gSet.sort((o1, o2)->genre.get(o2)-genre.get(o1));
        System.out.println(genre);
        System.out.println(genre.keySet());
        
        Iterator<String> iterator = gSet.iterator();
        
        PriorityQueue<Music> pq = new PriorityQueue<Music>();
        while(iterator.hasNext()) {
        	String g = iterator.next();
        	for(int i=0; i<plays.length; i++) {
        		if(g.equals(genres[i])) {        			
        			Music mu = new Music(i, plays[i]);
        			pq.add(mu);
        		}
        	}
            
        	if(pq.size()>=2) {
        		ans.add(pq.poll().index);
        	}
        	ans.add(pq.poll().index);
        	pq.clear();
        }
        
        answer = ans.toArray();
        
        System.out.println(ans.toString());
        
        return answer;
    }
}

class Music implements Comparable<Music>{
	int index;
	int playNum;
	
	Music(int i, int n){
		this.index = i;
		this.playNum = n;
	}
	
	@Override
	public int compareTo(Music m) {
		return this.playNum > m.playNum ? -1 : 1;
	}
	
}