package ProblemSolving.BOJ;

import java.io.*;

// RGB거리(https://www.acmicpc.net/problem/1149)
public class Main_S1_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] costArray = new int[N+1][3];
        int[][] dpTable = new int[N+1][3];

        for(int i = 1; i < N+1; i++){
            String[] tmp = (br.readLine()).split(" ");
            costArray[i][0] = Integer.parseInt(tmp[0]);
            costArray[i][1] = Integer.parseInt(tmp[1]);
            costArray[i][2] = Integer.parseInt(tmp[2]);
        }

        for(int i = 0; i < 3; i++){
         dpTable[1][i] = costArray[1][i];
        }

        for(int i = 2; i < N+1; i++){
            dpTable[i][0] = costArray[i][0] + Math.min(dpTable[i-1][1],dpTable[i-1][2]);
            dpTable[i][1] = costArray[i][1] + Math.min(dpTable[i-1][0],dpTable[i-1][2]);
            dpTable[i][2] = costArray[i][2] + Math.min(dpTable[i-1][0],dpTable[i-1][1]);
        }
        bw.write(Math.min(Math.min(dpTable[N][0],dpTable[N][1]),dpTable[N][2])+"");
        bw.flush();
    }
}