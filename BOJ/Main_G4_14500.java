package ProblemSolving.BOJ;

import java.io.*;

// 테트로미노(https://www.acmicpc.net/problem/14500)
public class Main_G4_14500 {

    public static int answer;
    public static int N;
    public static int M;
    public static int[][] ground;
    public static int[][] tetroY = new int[][]{{0,0,0,0},{0,1,2,3},{0,0,1,1},{0,0,0,-1},{0,0,0,1},{0,0,1,-1},{0,1,2,1},{0,1,1,2},{0,0,1,-1},{0,0,-1,-1},{0,0,1,1},{0,0,1,2},{0,1,2,0},{0,0,0,1},{0,1,1,1},{0,1,2,2},{0,0,-1,-2},{0,0,0,-1},{0,0,0,1}};
    public static int[][] tetroX = new int[][]{{0,1,2,3},{0,0,0,0},{0,1,0,1},{0,1,2,1},{0,1,2,1},{0,1,1,1},{0,0,0,1},{0,0,1,1},{0,1,0,1},{0,1,1,2},{0,1,1,2},{0,1,1,1},{0,0,0,1},{0,1,2,0},{0,0,1,2},{0,0,0,1},{0,1,1,1},{0,1,2,2},{0,1,2,2}};
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tmp = (rd.readLine()).split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        ground = new int[N][M];
        answer = 0;
        for(int i = 0; i < N; i++){
            String[] tmp2 = (rd.readLine()).split(" ");
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(tmp2[j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                answer = Math.max(answer,tetroPlus(i,j));
            }
        }
        wr.write(answer+"");
        wr.flush();
    }

    public static int tetroPlus(int y, int x){
        int max = 0;
        for(int i = 0; i < 19; i++){
            int sum = 0;
            for(int j = 0; j < 4; j++){
                int ny = y + tetroY[i][j];
                int nx = x + tetroX[i][j];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M){
                    sum = Integer.MIN_VALUE;
                    break;
                }
                sum += ground[ny][nx];
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}
