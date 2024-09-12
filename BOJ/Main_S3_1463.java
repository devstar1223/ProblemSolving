package ProblemSolving.BOJ;

import java.io.*;

public class Main_S3_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(rd.readLine());
        int[] dpTable = new int[N+1];
        dpTable[1] = 0;

        for(int i = 2; i < N+1; i++){
            dpTable[i] = dpTable[i-1]+1;

            if(i % 3 == 0){
                dpTable[i] = Math.min(dpTable[i/3]+1,dpTable[i]);
            }
            if(i % 2 == 0){
                dpTable[i] = Math.min(dpTable[i/2]+1,dpTable[i]);
            }
        }
        wr.write(String.valueOf(dpTable[N]));
        wr.flush();
    }
}
