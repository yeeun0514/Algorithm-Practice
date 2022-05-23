package 순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Solution {

    Map <String, List<Integer>> map = new HashMap<String, List<Integer>>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // map에 지원자 경우의 수에 따른 점수 정보를 넣음
        setInfoMap(info);
        // 각 경우의 수에 대한 점수를 오름차순으로 정렬
        sortScore();
        // 쿼리에 맞는 결과 출력
        answer = getAnswer(query);
        
        return answer;
    }

    // dfs를 사용하여 map에 지원자 경우의 수에 따른 정보를 넣음
    public void setInfoMap(String[] info){
        for(String i : info){
            dfs(i.split(" "), "", 0);
        }
    }

    // query를 key형식에 맞춰 변환 후 정답 찾기
    public int[] getAnswer(String[] query){
        int[] answer = new int[query.length];
        for(int i =0; i< query.length; i++){
            String str = query[i];
            str=str.replaceAll(" and ", "");
            String[] qInfo = str.split(" ");
            if(!map.containsKey(qInfo[0])){
                answer[i] = 0;
            }else{
                answer[i] = counter(qInfo[0], qInfo[1]);
            }
        }
        
        return answer;
    }

    // 각 경우에 대한 점수들 정렬
    public void sortScore(){
        Iterator<String> ite = map.keySet().iterator();
        while(ite.hasNext()){
            String key = ite.next();
            Collections.sort(map.get(key));
        }
    }

    // 해당 조건에 맞는 경우 중 점수에 부합하는 갯수 찾기
    public int counter(String str, String score){
        List<Integer> temp = map.get(str);
        int start = 0;
        int end = temp.size()-1;
        
        while(start<=end){
            int mid = (start+end)/2;
            if(temp.get(mid)<Integer.parseInt(score)){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return temp.size()-start;
    }

    // dfs 사용하여 모든 info에 대한 모든 경우의수 map에 key로 저장 및 점수 입력
    public void dfs(String[] info, String str, int depth){
        if(depth == 4){
            if(map.containsKey(str)){
                map.get(str).add(Integer.parseInt(info[4]));
                return;
            }else{
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(Integer.parseInt(info[4]));
                map.put(str, temp);
                return;
            }
        }

        dfs(info, str + info[depth], depth + 1);
        dfs(info, str + "-", depth + 1);
    }
}