package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 파일 합치기 3(https://www.acmicpc.net/problem/13975)
public class Main_G4_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            int K = Integer.parseInt(br.readLine());
            String[] file = (br.readLine()).split(" ");
            PriorityQueue<Long> heap = new PriorityQueue<>();
            for(int i = 0; i < K; i++){
                heap.add(Long.parseLong(file[i]));
            }
            long answer = 0;
            while(heap.size() > 1){
                long result = heap.poll() + heap.poll();
                heap.add(result);
                answer += result;
            }
            if(tc != T-1){
                bw.write(answer+"\n");
            }else{
                bw.write(answer+"");
            }
        }
        bw.flush();
    }
}