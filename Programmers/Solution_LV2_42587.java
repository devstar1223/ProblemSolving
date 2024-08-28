package ProblemSolving.Programmers;

import java.util.*;

class Solution_LV2_42587 {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        for(int i : priorities){
            q.offer(i);
        }

        Arrays.sort(priorities);

        for(int i : priorities){
            s.push(i);
        }

        while(!q.isEmpty()){
            if(q.peek() == s.peek()){
                if(location == 0){
                    return answer;
                }
                else{
                    location -= 1;
                    q.poll();
                    s.pop();
                    answer++;
                }
            }
            else{
                q.offer(q.poll());
                if(location == 0){
                    location = q.size()-1;
                }
                else{
                    location -= 1;
                }
            }
        }
        return answer;
    }
}