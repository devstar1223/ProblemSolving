package ProblemSolving.BOJ;

import java.io.*;

// 경로 찾기(https://www.acmicpc.net/problem/11403)
public class Main_S1_11403_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int N = Integer.parseInt(rd.readLine());
        int[][] ground = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] tmpS = (rd.readLine()).split(" ");
            for(int j = 0; j < N; j++){
                ground[i][j] = Integer.parseInt(tmpS[j]);
            }
        }

        // solve
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(ground[i][k] == 1 && ground[k][j] == 1){
                        ground[i][j] = 1;
                    }
                }
            }
        }

        // out
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j < N -1){
                    wr.write(ground[i][j] + " ");
                }
                else{
                    wr.write(ground[i][j]+"");
                }
            }
            wr.newLine();
        }
        wr.flush();
    }
}