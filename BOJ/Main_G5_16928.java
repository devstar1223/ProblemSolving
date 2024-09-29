package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 뱀과 사다리 게임(https://www.acmicpc.net/problem/16928)
public class Main_G5_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ground = new int[106];
        String[] tmp = (rd.readLine()).split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        for(int i = 0; i< N; i++){
            String[] ladderInfo = (rd.readLine()).split(" ");
            int x = Integer.parseInt(ladderInfo[0]);
            int y = Integer.parseInt(ladderInfo[1]);
            ground[x] = y;
        }
        for(int i = 0; i< M; i++){
            String[] snakeInfo = (rd.readLine()).split(" ");
            int u = Integer.parseInt(snakeInfo[0]);
            int v = Integer.parseInt(snakeInfo[1]);
            ground[u] = v;
        }
        for(int i = 0; i < 106; i++){
            ground[i] = (ground[i] == 0) ? i : ground[i];
        }

        boolean[] visit = new boolean[106];
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(ground[1]);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int current = q.poll();
                if(current >= 100){
                    wr.write(answer+"");
                    wr.flush();
                    q.clear();
                    break;
                }
                for(int j = 1; j < 7; j++){
                    if(!visit[current+j]){
                        visit[current+j] = true;
                        q.add(ground[current+j]);
                    }
                }
            }
            answer++;
        }
    }
}
