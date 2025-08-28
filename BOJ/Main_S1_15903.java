package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 카드 합체 놀이 (https://www.acmicpc.net/problem/15903)
public class Main_S1_15903{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] line = br.readLine().split(" ");

        // solve
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(String s : line){
            pq.add(Long.parseLong(s));
        }

        for(int i = 0; i < M; i++){
            long x = pq.poll();
            long y = pq.poll();
            pq.add(x+y);
            pq.add(x+y);
        }

        // output
        long answer = 0;
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        bw.write(answer+"");
        bw.flush();
    }
}
