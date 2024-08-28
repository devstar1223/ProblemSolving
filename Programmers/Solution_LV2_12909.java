package ProblemSolving.Programmers;
import java.util.*;

class Solution_LV2_12909 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            Character par = s.charAt(i);
            if(par == '('){
                stack.push(par);
            }
            else if(par == ')' && stack.isEmpty()){
                return false;
            }
            else if(par == ')'){
                stack.pop();
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return answer;
    }
}