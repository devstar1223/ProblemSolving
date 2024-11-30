package ProblemSolving.BOJ;

import java.io.*;

// 어두운건 무서워(https://www.acmicpc.net/problem/16507)
public class Main_S1_16507 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        String[] RCQ = (rd.readLine()).split(" ");
        int R = Integer.parseInt(RCQ[0]);
        int C = Integer.parseInt(RCQ[1]);
        int[][] ground = new int[R+1][C+1];
        for(int i = 1; i < R+1; i++){
            String[] tmp = (rd.readLine()).split(" ");
            for(int j = 1; j < C+1; j++){
                ground[i][j] = Integer.parseInt(tmp[j-1]);
            }
        }

        int[][] totalGround = new int[R+1][C+1];
        for(int i = 1; i < R+1; i++){
            for(int j = 1; j < C+1; j++){
                totalGround[i][j] = ground[i][j] + totalGround[i][j-1];
            }
        }

        int Q = Integer.parseInt(RCQ[2]);
        for(int i = 0; i < Q; i++){
            String[] rcInfo = (rd.readLine()).split(" ");
            int r1 = Integer.parseInt(rcInfo[0]);
            int c1 = Integer.parseInt(rcInfo[1]);
            int r2 = Integer.parseInt(rcInfo[2]);
            int c2 = Integer.parseInt(rcInfo[3]);
            int answer = calculate(r1,c1,r2,c2,totalGround);
            wr.write(answer+"\n");
            wr.flush();
        }
    }

    private static int calculate(int r1, int c1, int r2, int c2, int[][] totalGround) {
        int amount = (c2-c1+1) * (r2-r1+1);
        int total = 0;
        for(int i = r1; i <= r2; i++){
            total += totalGround[i][c2] - totalGround[i][c1-1];
        }
        return total/amount;
    }
}