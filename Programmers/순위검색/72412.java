package Programmers.순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        Solution s = new Solution();
        int[] answers = s.solution(info, query);
        for(int a : answers){
            System.out.print(a);
        }
    }


    Map <String, List<Integer>> map = new HashMap<String, List<Integer>>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(String i : info){
            dfs(i.split(" "), "", 0);
        }
        
        Iterator<String> ite = map.keySet().iterator();
        while(ite.hasNext()){
            String key = ite.next();
            // List<Integer> temp = map.get(key);
            Collections.sort(map.get(key));
        }

        for(int i =0; i< query.length; i++){
            String str = query[i];
            str.replaceAll(" and ", "");
            String[] qInfo = str.split(" ");
            if(!map.containsKey(qInfo[0])){
                answer[i] = 0;
            }else{
                answer[i] = counter(qInfo[0], qInfo[1]);
            }
        }
        
        return answer;
    }

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