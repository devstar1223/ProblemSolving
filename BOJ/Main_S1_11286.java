package ProblemSolving.BOJ;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

// 절댓값 힙(https://www.acmicpc.net/problem/11286)
public class Main_S1_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(rd.readLine());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(rd.readLine());
            if(num < 0){
                max.add(num);
            }
            else if(num > 0){
                min.add(num);
            }
            else{
                if(min.isEmpty() && max.isEmpty()){
                    wr.write(0+"\n");
                }
                else if(min.isEmpty()){
                    wr.write(max.poll()+"\n");
                }
                else if(max.isEmpty()){
                    wr.write(min.poll()+"\n");
                }
                else{
                    if((max.peek() * -1) <= min.peek()){
                        wr.write(max.poll()+"\n");
                    }
                    else{
                        wr.write(min.poll()+"\n");
                    }
                }
            }
        }
        wr.flush();
    }
}
