package ProblemSolving.BOJ;

import java.io.*;

// 가장 긴 증가하는 부분 수열 (https://www.acmicpc.net/problem/11053)
public class Main_S2_11053_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int[] array = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(line[i]);
        }

        // solve

        int[] dpTable = new int[N];
        dpTable[0] = 1;
        for(int i = 1; i < N; i++){
            int max = 1;
            for(int j = i-1; j >= 0; j--){
                if(array[j] < array[i]){
                    max = Math.max(max,dpTable[j]+1);
                }
            }
            dpTable[i] = max;
        }

        // output
        int maxAnswer = 1;

        for(int i : dpTable){
            maxAnswer = Math.max(i,maxAnswer);
        }

        bw.write(maxAnswer+"");
        bw.flush();
    }
}

