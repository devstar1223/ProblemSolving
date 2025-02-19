package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

//통나무 건너뛰기(https://www.acmicpc.net/problem/11497)
public class Main_S1_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());
            String[] treesStringArray = (br.readLine()).split(" ");
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for(String s : treesStringArray){
                maxHeap.add(Integer.parseInt(s));
            }

            Deque<Integer> deque = new ArrayDeque<>();
            boolean left = true;

            while(!maxHeap.isEmpty()){
                if(left){
                    deque.addFirst(maxHeap.poll());
                    left = false;
                }else{
                    deque.addLast(maxHeap.poll());
                    left = true;
                }
            }

            int answer = abs(deque.peekFirst(), deque.peekLast());

            while(deque.size() >= 2) {
                int originTreeHeight = deque.pollFirst();
                int newTreeHeight = deque.peekFirst();
                answer = Math.max(answer, abs(originTreeHeight, newTreeHeight));
            }
            bw.write(answer+"");
            if(tc != T-1){
                bw.newLine();
            }
        }

        bw.flush();
    }

    private static int abs(int tree1, int tree2){
        return Math.abs(tree1-tree2);
    }
}