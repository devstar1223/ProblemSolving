package ProblemSolving.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2805.농작물 수확하기
public class Solution_D3_2805 {

    public static void main(String args[]) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(rd.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(rd.readLine());
            int midPoint = (N-1)/2;
            int[][] ground = new int[N][N];
            for(int i = 0; i < N; i++){
                String[] tmp = (rd.readLine()).split("");
                for(int j = 0; j < N; j++){
                    ground[i][j] = Integer.parseInt(tmp[j]);
                }
            }

            int answer = 0;

            for(int i = 0; i < N; i++){
                answer += ground[i][midPoint];
            }

            for(int i = 1; i <= midPoint; i++){
                for(int j = i; j < N-i; j++){
                    answer += ground[j][midPoint-i];
                    answer += ground[j][midPoint+i];
                }
            }

            wr.write("#"+tc+" "+answer);

            if(tc != T){
                wr.newLine();
            }
        }
        wr.flush();
        rd.close();
        wr.close();
    }

}