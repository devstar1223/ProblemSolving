package ProblemSolving.BOJ;

import java.io.*;
// 케빈 베이컨의 6단계 법칙(https://www.acmicpc.net/problem/1389)
public class Main_S1_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = (rd.readLine()).split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int[][] ground = new int[N+1][N+1];
        for(int i = 0; i < M; i++){
            String[] tmp2 = (rd.readLine()).split(" ");
            int A = Integer.parseInt(tmp2[0]);
            int B = Integer.parseInt(tmp2[1]);

            ground[A][B] = 1;
            ground[B][A] = 1;
        }

        for(int k = 1; k < N+1; k++){ // 플로이드 - 워셜 알고리즘
            for(int i = 1; i < N+1; i++){
                for(int j = 1; j < N+1; j++){
                    if(ground[i][k] != 0 && ground[k][j] != 0){
                     if(ground[i][j] == 0){ // 0 이면 합한 값 넣어주기
                         ground[i][j] = ground[i][k] + ground[k][j];
                     }
                     else{ // 0 아니면 합한값이 현재값보다 작을때만 넣어주기(=최소값으로만 갱신)
                         ground[i][j] = Math.min(ground[i][k] + ground[k][j], ground[i][j]);
                     }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE; // 가장 지수 작은 사람 찾기
        int answer = 0;
        for(int i = 1; i < N+1; i++){
            int sum = 0;
            for(int j = 1; j < N+1; j++){
                if(i != j){
                    sum += ground[i][j];
                }
            }
            if(sum < min){
                min = sum;
                answer = i;
            }
        }
        wr.write(answer+"");
        wr.flush();
    }
}
