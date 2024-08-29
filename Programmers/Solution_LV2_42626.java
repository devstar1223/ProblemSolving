package ProblemSolving.Programmers;

import java.util.*;

class Solution_LV2_42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i : scoville){
            heap.add(i);
        }
        int answer = 0;
        while(heap.peek() < K && heap.size() > 1){
            int min1 = heap.poll();
            int min2 = heap.poll() * 2;
            heap.add(min1 + min2);
            answer++;
        }
        if(heap.peek() < K){
            return -1;
        }
        return answer;
    }
}
