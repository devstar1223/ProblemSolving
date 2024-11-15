package ProblemSolving.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//문제번호.문제명
public class Solution_D3_5789 {
    public static void main(String args[]) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(rd.readLine());
        for(int tc = 1; tc <= T; tc++) {
            String[] NQ = (rd.readLine()).split(" ");
            int N = Integer.parseInt(NQ[0]);
            int Q = Integer.parseInt(NQ[1]);

            int[] box = new int[N+1];

            for(int i = 1; i <= Q; i++){
                String[] LR = (rd.readLine()).split(" ");
                int L = Integer.parseInt(LR[0]);
                int R = Integer.parseInt(LR[1]);
                for(int j = L; j <= R; j++){
                    box[j] = i;
                }
            }

            wr.write("#"+tc+" ");

            for(int i = 1; i < N+1; i++){
                if(i != N){
                    wr.write(box[i]+" ");
                }
                else{
                    wr.write(box[i]+"");
                }
            }

            if(tc != T){
                wr.newLine();
            }
        }
        wr.flush();
        rd.close();
        wr.close();
    }
}