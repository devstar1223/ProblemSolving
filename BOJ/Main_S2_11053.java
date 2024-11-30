package ProblemSolving.BOJ;

import java.io.*;

// 가장 긴 증가하는 부분 수열(https://www.acmicpc.net/problem/11053)
public class Main_S2_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(rd.readLine());
        String[] tmp = (rd.readLine()).split(" ");
        int[] numberArray = new int[N];
        for(int i = 0; i < N; i++){
            numberArray[i] = Integer.parseInt(tmp[i]);
        }
        int[] DP = new int[N];
        DP[0] = 1;
        int streak = 1;
        for (int i = 1; i < N; i++) {
            if(numberArray[i] > numberArray[i-1]){
                DP[i] = DP[i-1] + 1;
            }else{
                DP[i] = 1;
            }
            for(int j = i; j >= 0; j--){
                if(DP[j] >= DP[i] && numberArray[j] < numberArray[i]){
                    DP[i] = DP[j] + 1;
                }
            }
            streak = Math.max(streak,DP[i]);
        }

        wr.write(streak+"");
        wr.flush();
    }
}