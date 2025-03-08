package ProblemSolving.BOJ;

import java.io.*;

// 구슬 찾기(https://www.acmicpc.net/problem/2617)
public class Main_G4_2617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        // heavy[1][2] == 1 이라면, 1이 2보다 큰것이다.
        int[][] heavy = new int[N+1][N+1];
        int[][] light = new int[N+1][N+1];
        int answer = 0;
        int middle = (N+1)/2;

        for(int i = 0; i < M; i ++){
            String[] AB = (br.readLine()).split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            heavy[A][B] = 1;
            light[B][A] = 1;
        }

        for(int k = 1; k < N+1; k++){
            for(int i = 1; i < N+1; i++){
                for(int j = 1; j < N+1; j++){
                    if(heavy[i][k] == 1 && heavy[k][j] == 1){
                        heavy[i][j] = 1;
                    }
                    if(light[i][k] == 1 && light[k][j] == 1){
                        light[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 1; i < N+1; i++){
            int heavyCount = 0;
            int lightCount = 0;

            for(int j = 1; j < N+1; j++){
                if(heavy[i][j] == 1){
                    heavyCount++;
                }
                if(light[i][j] == 1){
                    lightCount++;
                }
            }

            if(heavyCount >= middle || lightCount >= middle){
                answer++;
            }
        }

        bw.write(answer+"");
        bw.flush();
    }
}