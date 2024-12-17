package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 운동(https://www.acmicpc.net/problem/1956)
public class Main_G4_1956 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] VE = (rd.readLine()).split(" ");
        int V = Integer.parseInt(VE[0]);
        int E = Integer.parseInt(VE[1]);
        int INF = Integer.MAX_VALUE;

        int ground[][] = new int[V + 1][V + 1];
        for (int[] array : ground) {
            Arrays.fill(array, INF);
        }

        for (int i = 0; i < E; i++) {
            String[] ABC = (rd.readLine()).split(" ");
            int A = Integer.parseInt(ABC[0]);
            int B = Integer.parseInt(ABC[1]);
            int C = Integer.parseInt(ABC[2]);
            ground[A][B] = C;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (ground[i][k] != INF && ground[k][j] != INF) {
                        ground[i][j] = Math.min(ground[i][j], ground[i][k] + ground[k][j]);
                    }
                }
            }
        }

        int answer = INF;
        for(int i = 1; i <= V; i++){
            answer = Math.min(ground[i][i],answer);
        }
        if(answer == INF){
            wr.write(-1+"");
        }else{
            wr.write(answer+"");
        }
        wr.flush();
    }
}