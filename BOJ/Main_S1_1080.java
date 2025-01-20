package ProblemSolving.BOJ;

import java.io.*;

// 행렬(https://www.acmicpc.net/problem/1080)
public class Main_S1_1080 {

    static int[][] A,B;
    static int N,M;
    static int ANSWER = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        A = new int[N][M];
        B = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] line = (br.readLine()).split("");
            for(int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i = 0; i < N; i++){
            String[] line = (br.readLine()).split("");
            for(int j = 0; j < M; j++){
                B[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i = 0; i < N-2; i++){
            for(int j = 0; j < M-2; j++){
                if(A[i][j] != B[i][j]){
                    turnValue(i,j);
                }
            }
        }

        bw.write(check()+"");
        bw.flush();
    }

    private static int check() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(A[i][j] != B[i][j]){
                    return -1;
                }
            }
        }
        return ANSWER;
    }

    private static void turnValue(int r, int c){
        for(int i = r; i < r+3; i++){
            for(int j = c; j < c+3; j++){
                if(A[i][j] == 0){
                    A[i][j] = 1;
                }else{
                    A[i][j] = 0;
                }
            }
        }
        ANSWER++;
    }
}