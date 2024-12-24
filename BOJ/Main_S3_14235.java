package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 크리스마스 선물(https://www.acmicpc.net/problem/14235)
public class Main_S3_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            if(s.equals("0")){
                if(maxHeap.isEmpty()){
                    bw.write("-1\n");
                }else{
                    bw.write(maxHeap.poll()+"\n");
                }
            }else{
             String[] giftStringArray = s.split(" ");
             for(int j = 0; j < Integer.parseInt(giftStringArray[0]); j++){
                 maxHeap.add(Integer.parseInt(giftStringArray[j+1]));
             }
            }
        }
        bw.flush();
    }
}