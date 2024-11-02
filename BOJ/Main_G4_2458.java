package ProblemSolving.BOJ;

import java.io.*;

// 키 순서(https://www.acmicpc.net/problem/2458)
public class Main_G4_2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        String[] NM = (rd.readLine()).split(" ");
        int answer = 0;
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[][] ground = new int[N+1][N+1];
        for(int i = 0 ; i < M; i++){
            String[] aSmallThanB =  (rd.readLine()).split(" ");
            int a = Integer.parseInt(aSmallThanB[0]);
            int b = Integer.parseInt(aSmallThanB[1]);
            ground[a][b] = -1;
            ground[b][a] = 1;
        }

        // solve
        for(int k = 1; k < N+1; k++){
            for(int i = 1; i < N+1; i++){
                for(int j = 1; j < N+1; j++){
                    if(ground[i][k] == ground[k][j] && ground[i][k] != 0){
                        ground[i][j] = ground[i][k];
                    }
                }
            }
        }

        // out
        for(int i = 1; i < N+1; i++){
            boolean add = true;
            for(int j = 1; j < N+1; j++){
                if(ground[i][j] == 0 && i!=j){
                    add = false;
                    break;
                }
            }
            if(add){
                answer++;
            }
        }

        wr.write(answer+"");
        wr.flush();


    }
}