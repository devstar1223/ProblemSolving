package ProblemSolving.BOJ;

import java.io.*;

// 꿀 따기(https://www.acmicpc.net/problem/21758)
public class Main_G5_21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(rd.readLine());
        String[] groundString = (rd.readLine()).split(" ");
        int[] ground = new int[N];
        for(int i = 0; i < ground.length; i++){
            ground[i] = Integer.parseInt(groundString[i]);
        }

        int[] TP = new int[N]; // 누적합 정방향( -> )
        int[] RTP = new int[N]; // 누적합 역방향( <- )
        TP[0] = ground[0];
        RTP[N-1] = ground[N-1];
        for(int i = 1; i < N; i++){
            TP[i] = TP[i-1] + ground[i];
            RTP[N-1-i] = RTP[N-i] + ground[N-1-i];
        }

        int answer = Integer.MIN_VALUE;

        for(int i = 1; i < N-1; i++){ // 정방향, 벌집 오른쪽 고정
            answer = Math.max(answer,TP[N-1]*2-TP[0]-ground[i]-TP[i]);
        }

        for(int i = 1; i < N-1; i++){ // 역방향, 벌집 왼쪽 고정
            answer = Math.max(answer,RTP[0]*2-RTP[N-1]-ground[i]-RTP[i]);
        }

        for(int i = 1; i < N-1; i++){ // 양쪽 방향, 벌집이 움직인다.
            answer = Math.max(answer,TP[i] + RTP[i] - TP[0] - RTP[N-1]);
        }

        wr.write(answer+"");
        wr.flush();
    }
}