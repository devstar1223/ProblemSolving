package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

//부분합(https://www.acmicpc.net/problem/1806)
public class Main_G4_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NS = (br.readLine()).split(" ");
        int N = Integer.parseInt(NS[0]);
        int S = Integer.parseInt(NS[1]);

        String[] sequenceString = (br.readLine()).split(" ");
        Queue<Integer> q = new LinkedList<>();

        int answer = Integer.MAX_VALUE;
        int totalValue = 0;
        int size = 0;

        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(sequenceString[i]);

            q.add(number);
            totalValue += number;
            size++;

            while(totalValue >= S && !q.isEmpty()){
                answer = Math.min(answer,size);
                totalValue -= q.poll();
                size--;
            }
        }

        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        bw.write(answer+"");
        bw.flush();
    }
}