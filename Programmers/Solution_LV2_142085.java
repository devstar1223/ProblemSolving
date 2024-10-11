package ProblemSolving.Programmers;

import java.util.*;

public class Solution_LV2_142085 {
    class Solution {
        public int solution(int n, int k, int[] enemy) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            int answer = 0;
            for(int i = 0; i < enemy.length; i++){
                if(n - enemy[i] >= 0){
                    answer++;
                    maxHeap.add(enemy[i]);
                    n -= enemy[i];
                }
                else{ // 여기서는 병사의 소모가 없어야함.
                    if(k == 0){
                        break;
                    }
                    else{
                        k--;
                        maxHeap.add(enemy[i]);
                        n -= enemy[i];
                        n += maxHeap.poll();
                        if(n < 0){
                            break;
                        }
                        answer++;
                    }
                }
            }
            return answer;
        }
    }
}
