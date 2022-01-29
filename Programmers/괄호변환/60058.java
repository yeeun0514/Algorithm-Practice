import java.util.Stack;

class Solution {
    public String solution(String p) {
        if(check(p)) {
        	return p;
        }else {
        	return dfs(p);
        }
    }
    
    public boolean check(String u) {
    	Stack<Character> stack = new Stack<>();
    	for(int i=0; i<u.length(); i++) {
    		char c = u.charAt(i);
    		if(c == '(') {
    			stack.add(c);
    		}else {
    			if(stack.isEmpty()) {
    				return false;
    			}else {
    				stack.pop();
    			}
    		}
    	}
    	if(!stack.isEmpty()) {
    		return false;
    	}
    	return true;
    }
    
    public String dfs(String w) {
    	if(w.length()==0) {
    		return "";
    	}
    	String u = "";
    	String v = "";
    	int count1=0, count2=0;
    	for(int i=0; i<w.length(); i++) {
    		char c = w.charAt(i);
    		if(c=='(') {
    			count1++;
    		}else {
    			count2++;
    		}
    		if((count1 != 0 && count2 != 0) && count1 == count2) {
    			u = w.substring(0, i+1);
    			if(i != w.length()-1) {
    				v = w.substring(i+1, w.length());
    			}
    			break;
    		}
    	}
    	if(check(u)) {
    		return u + dfs(v);
    	}else {
    		String temp = "(" + dfs(v) + ")";
    		u = u.substring(1, u.length()-1);
    		u = u.replace("(", ".");
    		u = u.replace(")", "(");
    		u = u.replace(".", ")");
    		return temp + u;
    	}
    }
}