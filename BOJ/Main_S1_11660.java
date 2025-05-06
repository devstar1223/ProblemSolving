package ProblemSolving.ProblemSolving.BOJ;

import java.io.*;

// 구간 합 구하기5(https://www.acmicpc.net/problem/11660)
public class Main_S1_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NMArray = (br.readLine()).split(" ");
        int N = Integer.parseInt(NMArray[0]);
        int M = Integer.parseInt(NMArray[1]);

        int[][] ground = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            String[] line = (br.readLine()).split(" ");
            for(int j = 1; j < N+1; j++){
                ground[i][j] = Integer.parseInt(line[j-1]);
            }
        }

        int[][] totalSumGround = new int[N+1][N+1];
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                totalSumGround[i][j] = totalSumGround[i][j-1] + totalSumGround[i-1][j] + ground[i][j] - totalSumGround[i-1][j-1];
            }
        }

        for(int i = 0; i < M; i++){
            int answer = 0;
            String[] line = (br.readLine()).split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);

            answer = totalSumGround[x2][y2] - totalSumGround[x2][y1-1] - totalSumGround[x1-1][y2] + totalSumGround[x1-1][y1-1];
            bw.write(answer+"");
            if(i != M-1){
                bw.newLine();
            }
        }
        bw.flush();
    }
}
