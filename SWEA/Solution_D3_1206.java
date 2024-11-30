package ProblemSolving.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1206.View
public class Solution_D3_1206 {
    public static void main(String args[]) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;
        for(int tc = 1; tc <= T; tc++) {
            int answer = 0;
            int N = Integer.parseInt(rd.readLine());
            String[] heightInfoString = (rd.readLine()).split(" ");
            int[] heightInfo = new int[N];
            for(int i = 0; i < N; i++){
                heightInfo[i] = Integer.parseInt(heightInfoString[i]);
            }
            for(int i = 2; i < N-2; i++){
                int maxHeight = Math.max(Math.max(heightInfo[i-2],heightInfo[i-1]),Math.max(heightInfo[i+2],heightInfo[i+1]));
                answer += Math.max(heightInfo[i]-maxHeight,0);
            }
            wr.write("#"+tc+" "+answer);
            if(tc != T){
                wr.newLine();
            }
            wr.flush();
        }
        rd.close();
        wr.close();
    }
}