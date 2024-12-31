package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 포도주 시식(https://www.acmicpc.net/problem/2156)
public class Main_S1_2156 {

    public static int[] grape;
    public static int[][] dpTable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dpTable = new int[N][3];
        for(int i=0; i<N; i++){
            Arrays.fill(dpTable[i], -1);
        }
        grape = new int[N];

        for(int i = 0; i < N; i++){
            grape[i] = Integer.parseInt(br.readLine());
        }

        bw.write(dp(N-1,0)+"");

        bw.flush();
    }

    private static int dp(int number,int streak) {
        if(dpTable[number][streak] != -1){
            return dpTable[number][streak];
        }

        if(number > 0){
            if(streak == 2){
                dpTable[number][streak] = dp(number-1,0);
            }else{
                dpTable[number][streak] = Math.max(dp(number-1,0),grape[number] + dp(number-1,streak+1));
            }
        }else{
            if(streak != 2){
                dpTable[number][streak] = grape[number];
            } else{
                dpTable[number][streak] = 0;
            }
        }

        return dpTable[number][streak];
    }


}