package ProblemSolving.BOJ;

import java.io.*;

// 숫자 정사각형(https://www.acmicpc.net/problem/1051)
public class Main_S3_1051 {

    public static int[][] ground;
    public static int N,M,len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        len = Math.min(N,M);
        ground = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] stringLine = (br.readLine()).split("");
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(stringLine[j]);
            }
        }

        // 최소 크기 (넓이 1인 사각형이 0으로 시작 / 넓이 2면 1)
        int size = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                size = Math.max(size,calculate(i,j,size));
            }
        }

        int answer = (size+1)*(size+1);

        bw.write(answer+"");
        bw.flush();

    }

    private static int calculate(int y, int x, int size){
        int value = size;

        for(int i = size; i <= len; i++){
            if(y + i >= N || x + i >= M){
                return value;
            }

            if(ground[y][x] == ground[y+i][x]
                    && ground[y][x] == ground[y][x+i]
                    && ground[y][x] == ground[y+i][x+i]){
                value = i;
            }
        }
        return value;
    }
}
